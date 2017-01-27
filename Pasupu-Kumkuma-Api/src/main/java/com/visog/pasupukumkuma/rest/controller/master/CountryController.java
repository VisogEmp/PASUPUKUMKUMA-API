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
import com.visog.pasupukumkuma.req.CountryReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.CountryService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class CountryController {
	
	
	private static final Logger logger = Logger.getLogger(CountryController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private CountryService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/country")
	public PasupuKumkumaResponse createCountry(CountryReq req) {

		service.saveCountry(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("country saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/country/{countryId}")
	public PasupuKumkumaResponse updateRole(@PathParam("countryId") String countryId, CountryReq req) {

		service.updateCountry(req, countryId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("country updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@GET
	@Path("/country")
	public PasupuKumkumaResponse getRoles() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCountries());
		pasupuKumkumaResponse.setMessage("country fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@GET
	@Path("/country/{countryId}")
	public PasupuKumkumaResponse getRole(@PathParam("countryId") String countryId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCountry(countryId));
		pasupuKumkumaResponse.setMessage("Role fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@DELETE
	@Path("/country/{countryId}")
	public PasupuKumkumaResponse deleteRole(@PathParam("countryId") String countryId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteCountry(countryId)) {
			pasupuKumkumaResponse.setMessage("country deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the country");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}

	



}
