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
import com.visog.pasupukumkuma.req.PujaSamagriReq;
import com.visog.pasupukumkuma.req.RolesReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.PujaSamagriService;
import com.visog.pasupukumkuma.service.master.RolesService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class PujaSamagriController {

	private static final Logger logger = Logger.getLogger(PujaSamagriController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private PujaSamagriService service;

	/**
	 * This method creates the PujaSamagri
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/puja_samagri")
	public PasupuKumkumaResponse createPujaSamagri(PujaSamagriReq req) {

		service.savePujaSamagri(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("PujaSamagri saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	/**
	 * This method updates the PujaSamagri
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/puja_samagri/{PUJA_SAMAGRI_ID}")
	public PasupuKumkumaResponse updateRole(@PathParam("pujasamagriId") String pujasamagriId, PujaSamagriReq req) {

		service.updatePujaSamagri(req, pujasamagriId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Pujasamagri updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	/**
	 * This method retrieves all pujasamagri
	 * 
	 * @return
	 */
	@GET
	@Path("/puja_samagri")
	public PasupuKumkumaResponse getPujaSamagri() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPujaSamagri());
		pasupuKumkumaResponse.setMessage("PujaSamagri fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	/**
	 * This method retrieves a single PujaSamagri
	 * 
	 * @return
	 */

	@GET
	@Path("/puja_samagri/{PUJA_SAMAGRI_ID}")
	public PasupuKumkumaResponse getPujaSamagri(@PathParam("pujasamagriId") String pujasamagriId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPujaSamagri(pujasamagriId));
		pasupuKumkumaResponse.setMessage("PujaSamagri fetched succcessfully");
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
	@Path("/puja_samagri/{PUJA_SAMAGRI_ID}")
	public PasupuKumkumaResponse deletePujaSamagri(@PathParam("pujasamagriId") String pujasamagriId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deletePujaSamagri(pujasamagriId)) {
			pasupuKumkumaResponse.setMessage("PujaSamagri deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he pujasamagri");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}
}
