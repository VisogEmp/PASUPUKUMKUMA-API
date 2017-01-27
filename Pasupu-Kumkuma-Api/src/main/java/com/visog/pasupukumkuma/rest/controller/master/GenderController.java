package com.visog.pasupukumkuma.rest.controller.master;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
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
	@Consumes("application/json")
	@Path("/gender")
	public PasupuKumkumaResponse createGender(GenderReq req) {

		service.saveGender(req);

		PasupuKumkumaResponse pasupukumkumaResponse = new PasupuKumkumaResponse();
		pasupukumkumaResponse.setMessage("Gender saved succcessfully");
		pasupukumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupukumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupukumkumaResponse;
	}

	/**
	 * This method updates the Role
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes("application/json")
	@Path("/gender/{genderId}")
	public PasupuKumkumaResponse updateGender(@PathParam("id") String genderId, GenderReq req) {

		service.updateGender(req, genderId);

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
	@Consumes("application/json")
	@Path("/gender")
	public PasupuKumkumaResponse getGenders() {

		service.getGenders();

		PasupuKumkumaResponse pasupukumkumaResponse = new PasupuKumkumaResponse();
		pasupukumkumaResponse.setMessage("Gender fetched succcessfully");
		pasupukumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupukumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupukumkumaResponse;

	}

	/**
	 * This method retrieves a single Gender
	 * 
	 * @return
	 */

	@GET
	@Produces("application/json")
	@Path("/gender/{genderId}")
	public PasupuKumkumaResponse getGender(String id) {

		service.getGender(id);

		PasupuKumkumaResponse pasupukumkumaResponse = new PasupuKumkumaResponse();
		pasupukumkumaResponse.setMessage("Gender fetched succcessfully");
		pasupukumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupukumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupukumkumaResponse;

	}

}
