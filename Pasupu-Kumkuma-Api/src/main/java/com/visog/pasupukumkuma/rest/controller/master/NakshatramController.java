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
import com.visog.pasupukumkuma.req.NakshatramReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.NakshatramService;


@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class NakshatramController {

	private static final Logger logger = Logger.getLogger(NakshatramController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private NakshatramService service;

	/**
	 * This method creates the Role
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/nakshatram")
	public PasupuKumkumaResponse createNakshatram(NakshatramReq req) {

		service.saveNakshatram(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Nakshatram saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method updates the Role
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/nakshatram/{nakshatramId}")
	public PasupuKumkumaResponse updateRole(@PathParam("nakshatramId") String nakshatramId, NakshatramReq req) {

		service.updateNakshatram(req, nakshatramId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Nakshatram updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method retrieves all Nakshatram
	 * 
	 * @return
	 */
	@GET
	@Path("/nakshatram")
	public PasupuKumkumaResponse getNakshatram() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getNakshatram());
		pasupuKumkumaResponse.setMessage("Nakshatram fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method retrieves a single Role
	 * 
	 * @return
	 */

	@GET
	@Path("/nakshatram/{nakshatramId}")
	public PasupuKumkumaResponse getNakshatram(@PathParam("nakshatramId") String nakshatramId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getNakshatram(nakshatramId));
		pasupuKumkumaResponse.setMessage("Nakshatram fetched succcessfully");
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
	@Path("/nakshatram/{nakshatramId}")
	public PasupuKumkumaResponse deleteNakshatram(@PathParam("nakshatramId") String nakshatramId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteNakshatram(nakshatramId)) {
			pasupuKumkumaResponse.setMessage("Nakshyatram deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he Nakshyatram");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	 
	
	}
}
