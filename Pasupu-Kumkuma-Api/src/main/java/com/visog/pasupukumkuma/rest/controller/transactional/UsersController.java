package com.visog.pasupukumkuma.rest.controller.transactional;

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
import com.visog.pasupukumkuma.req.StateReq;
import com.visog.pasupukumkuma.req.transactional.UsersReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transactional.UsersService;


@Path("/transactional")
@Produces(MediaType.APPLICATION_JSON)
public class UsersController {
	
	private static final Logger logger = Logger.getLogger(UsersController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private UsersService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/users")
	public PasupuKumkumaResponse createUsers(UsersReq req) {

		service.saveUsers(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("user saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/users/{USERS_ID}")
	public PasupuKumkumaResponse updateUsers(@PathParam("USERS_ID") String usersId, UsersReq req) {

		service.updateUsers(req, usersId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("user updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@GET
	@Path("/users")
	public PasupuKumkumaResponse getUsers() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getUsers());
		pasupuKumkumaResponse.setMessage("user fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}


	@GET
	@Path("/users/{USERS_ID}")
	public PasupuKumkumaResponse getUsers(@PathParam("USERS_ID") String usersId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getUsers(usersId));
		pasupuKumkumaResponse.setMessage("user fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@DELETE
	@Path("/users/{USERS_ID}")
	public PasupuKumkumaResponse deleteUsers(@PathParam("USERS_ID") String usersId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteUsers(usersId)) {
			pasupuKumkumaResponse.setMessage("user deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the user");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}

}
