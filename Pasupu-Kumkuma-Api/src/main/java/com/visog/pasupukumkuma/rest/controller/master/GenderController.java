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
import com.visog.pasupukumkuma.req.GenderReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.GenderService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class GenderController {

	private static final Logger logger = Logger.getLogger(RolesController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private GenderService service;

	/**
	 * This method creates the Gender
	 * 
	 * @param req
	 * @return
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/gender")
	public PasupuKumkumaResponse createGender(GenderReq req) {

		service.saveGender(req);;

		PasupuKumkumaResponse pasupukumkumaResponse = new PasupuKumkumaResponse();
		pasupukumkumaResponse.setMessage("Gender saved succcessfully");
		pasupukumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupukumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupukumkumaResponse;
	}

	/**
	 * This method updates the gender
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/gender/{GENDER_ID}")
	public PasupuKumkumaResponse updateGender(@PathParam("GENDER_ID") String genderId, GenderReq req) {

		service.updateGender(req, genderId);;

		PasupuKumkumaResponse pasupukumkumaResponse = new PasupuKumkumaResponse();
		pasupukumkumaResponse.setMessage("Gender updated succcessfully");
		pasupukumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupukumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupukumkumaResponse;

	}

	/**
	 * This method retrieves all gender
	 * 
	 * @return
	 */
	@GET
	
	@Path("/gender")
	public PasupuKumkumaResponse getGenders() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getGender());
		pasupuKumkumaResponse.setMessage("gender fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method retrieves a single Gender
	 * 
	 * @return
	 */

	@GET
	@Path("/gender/{GENDER_ID}")
	public PasupuKumkumaResponse getGender(String id) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getGender(id));
		pasupuKumkumaResponse.setMessage("Gender fetched succcessfully");
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
	@Path("/gender/{GENDER_ID}")
	public PasupuKumkumaResponse deleteRole(@PathParam("GENDER_ID") String genderId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteGender(genderId)) {
			pasupuKumkumaResponse.setMessage("Gender deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he gender");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}

}
