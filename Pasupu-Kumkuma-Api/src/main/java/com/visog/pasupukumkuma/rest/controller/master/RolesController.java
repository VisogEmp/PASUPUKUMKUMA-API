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
import com.visog.pasupukumkuma.req.RolesReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.RolesService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class RolesController {

	private static final Logger logger = Logger.getLogger(RolesController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private RolesService service;

	/**
	 * This method creates the Role
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/roles")
	public PasupuKumkumaResponse createRole(RolesReq req) {

		service.saveRole(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Role saved succcessfully");
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
	@Path("/roles/{roleId}")
	public PasupuKumkumaResponse updateRole(@PathParam("roleId") String roleId, RolesReq req) {

		service.updateRole(req, roleId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Role updated succcessfully");
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
	@Path("/roles")
	public PasupuKumkumaResponse getRoles() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getRoles());
		pasupuKumkumaResponse.setMessage("Roles fetched succcessfully");
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
	@Path("/roles/{roleId}")
	public PasupuKumkumaResponse getRole(@PathParam("roleId") String roleId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getRole(roleId));
		pasupuKumkumaResponse.setMessage("Role fetched succcessfully");
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
	@Path("/roles/{roleId}")
	public PasupuKumkumaResponse deleteRole(@PathParam("roleId") String roleId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteRole(roleId)) {
			pasupuKumkumaResponse.setMessage("Role deleted succcessfully");
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
