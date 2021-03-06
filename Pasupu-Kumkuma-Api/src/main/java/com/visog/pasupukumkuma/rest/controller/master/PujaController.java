
package com.visog.pasupukumkuma.rest.controller.master;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.constants.Status;
import com.visog.pasupukumkuma.req.PujaReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.PujaService;


@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class PujaController {
	
	private static final Logger logger = Logger.getLogger(PujaController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private PujaService service;

	/**
	 * This method creates the puja
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/puja")
	
	public PasupuKumkumaResponse createPujas(PujaReq req) {

		service.savePuja(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Puja saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method updates the Puja
	 * 
	 * @param req
	 * @return
	 */
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/puja/{PUJA_ID}")
	public PasupuKumkumaResponse updatePujas(@PathParam("PUJA_ID") String pujasId, PujaReq req) {

		service.updatePuja(req, pujasId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Puja updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method retrieves all puja
	 * 
	 * @return
	 */
	
	@GET
	@Path("/puja")
	public PasupuKumkumaResponse getPujas() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPuja());
		pasupuKumkumaResponse.setMessage("Puja fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method retrieves a single Puja
	 * 
	 * @return
	 */


	@GET
	@Path("/puja/{PUJA_ID}")
	public PasupuKumkumaResponse getPujas(@PathParam("PUJA_ID") String pujasId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPuja(pujasId));
		pasupuKumkumaResponse.setMessage("Puja fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	/**
	 * This method delete the role
	 * 
	 * @return
	 */
	
	@DELETE
	@Path("/puja/{PUJA_ID}")
	public PasupuKumkumaResponse deletePujas(@PathParam("PUJA_ID") String pujasId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deletePuja(pujasId)) {
			pasupuKumkumaResponse.setMessage("Puja deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he puja");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}
}


	
