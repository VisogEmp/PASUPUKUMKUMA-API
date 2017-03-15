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
import com.visog.pasupukumkuma.req.transactional.UserRequestReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transactional.UserRequestService;

/*sudha*/
@Path("/transactional")
@Produces(MediaType.APPLICATION_JSON)

public class UserRequestController {

	public static final Logger logger = Logger.getLogger(UserRequestController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	UserRequestService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/userRequest")
	public PasupuKumkumaResponse createUserRequest(UserRequestReq req) {

		service.saveUserRequests(req);
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("UserRequest saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/userRequest/{USER_REQUEST_ID}")
	public PasupuKumkumaResponse updateUserRequest(@PathParam("USER_REQUEST_ID") String userRequestId, UserRequestReq req) {

		service.updateUserRequests(req, userRequestId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("userRequest updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;
	}

	
	/**
	 * This method retrieves all roles
	 * 
	 * @return
	 */
	@GET
	@Path("/userRequest")
	public PasupuKumkumaResponse getUserRequests() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getUserRequests());
		pasupuKumkumaResponse.setMessage("UserRequest fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	@GET
	@Path("/userRequest/{USER_REQUEST_ID}")
	public PasupuKumkumaResponse getUserRequests(@PathParam("USER_REQUEST_ID") String userRequestId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getUserRequests(userRequestId));
		pasupuKumkumaResponse.setMessage("userRequest fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@DELETE
	@Path("/userRequest/{USER_REQUEST_ID}")
	public PasupuKumkumaResponse deleteUserRequests(@PathParam("USER_REQUEST_ID") String userRequestId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteUserRequests(userRequestId)) {
			pasupuKumkumaResponse.setMessage("userRequest deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the userRequest");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	}

	
	
	
}
