package com.visog.pasupukumkuma.rest.controller.master;

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
import com.visog.pasupukumkuma.req.RolesReq;
import com.visog.pasupukumkuma.req.StatusReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.StatusService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class StatusController {

	private static final Logger logger = Logger.getLogger(StatusController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	private StatusService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/status")
	public PasupuKumkumaResponse createStatus(StatusReq req) {

		service.saveStatus(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Status saved succcessfully");
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
	@Path("/status/{STATUS_ID")
	public PasupuKumkumaResponse updateStatus(@PathParam("statusId") String statusId, StatusReq req) {

		service.updateStatus(req, statusId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Status updated succcessfully");
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
	@Path("/status")
	public PasupuKumkumaResponse getRoles() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getStatus());
		pasupuKumkumaResponse.setMessage("Status fetched succcessfully");
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
	@Path("/status/{STATUS_ID}")
	public PasupuKumkumaResponse getStatus(@PathParam("statusId") String statusId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getStatus(statusId));
		pasupuKumkumaResponse.setMessage("Status fetched succcessfully");
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
	@Path("/status/{STATUS_ID}")
	public PasupuKumkumaResponse deleteRole(@PathParam("statusId") String statusId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteStatus(statusId)) {
			pasupuKumkumaResponse.setMessage("Status deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he role");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}


}
