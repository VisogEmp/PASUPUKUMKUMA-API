package com.visog.pasupukumkuma.rest.controller.transaction;

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
import com.visog.pasupukumkuma.req.transaction.UsersReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transaction.UsersService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class UsersController {

	private static final Logger logger = Logger.getLogger(UsersController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private UsersService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/users")
	public PasupuKumkumaResponse createUser(UsersReq req) {

		service.saveUser(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Users saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/users/{usersId}")
	public PasupuKumkumaResponse updateUser(@PathParam("usersId") String usersId, UsersReq req) {

		service.updateUser(req, usersId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Users updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@GET
	@Path("/users")
	public PasupuKumkumaResponse getUsers() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getUsers());
		pasupuKumkumaResponse.setMessage("Users fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@GET
	@Path("/users/{usersId}")
	public PasupuKumkumaResponse getUser(@PathParam("usersId") String usersId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getUser(usersId));
		pasupuKumkumaResponse.setMessage("User fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@DELETE
	@Path("/users/{usersId}")
	public PasupuKumkumaResponse deleteRole(@PathParam("usersId") String usersId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if (service.deleteUser(usersId)) {
			pasupuKumkumaResponse.setMessage("Users deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the User");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return pasupuKumkumaResponse;

	}

}
