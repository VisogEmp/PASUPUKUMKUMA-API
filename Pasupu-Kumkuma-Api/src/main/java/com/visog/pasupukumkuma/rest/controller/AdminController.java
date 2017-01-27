package com.visog.pasupukumkuma.rest.controller;
 
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.constants.Status;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.AdminService;
import com.visog.pasupukumkuma.utils.ParamUtils;
 
@Path("/admin")
public class AdminController {
	
	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private AdminService service;
 
	/**
	 * This method creates the user for the given institution
	 * 
	 * @param institutionId
	 * @param userReq
	 * @return
	 */
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("test/{id}")
	public PasupuKumkumaResponse createUser(@PathParam("id") String instStr) {
		

		Long institutionId = ParamUtils.getLongParam(instStr, userIdentifier);
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("test message");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		pasupuKumkumaResponse.setData("Hai");
		
		return pasupuKumkumaResponse;
	}	

}