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
import com.visog.pasupukumkuma.req.ManagerReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.ManagerService;


@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class ManagerController {
	
	private static final Logger logger = Logger.getLogger(ManagerController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private ManagerService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/manager")
	public PasupuKumkumaResponse createManager(ManagerReq req) {

		service.saveManager(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Manager saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/manager/{managerId}")
	public PasupuKumkumaResponse updateRole(@PathParam("managerId") String managerId, ManagerReq req) {

		service.updateManager(req, managerId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Manager updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@GET
	@Path("/manager")
	public PasupuKumkumaResponse getRoles() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getManagers());
		pasupuKumkumaResponse.setMessage("manager fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@DELETE
	@Path("/manager/{managerId}")
	public PasupuKumkumaResponse deleteRole(@PathParam("managerId") String managerId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteManagers(managerId)) {
			pasupuKumkumaResponse.setMessage("Manager deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the manager");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}

}
