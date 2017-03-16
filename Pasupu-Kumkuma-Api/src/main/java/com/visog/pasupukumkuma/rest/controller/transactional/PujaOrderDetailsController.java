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
import com.visog.pasupukumkuma.req.transactional.PujaOrderDetailsReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transactional.PujaOrderDetailsService;

@Path("/transactional")
@Produces(MediaType.APPLICATION_JSON)
public class PujaOrderDetailsController {
	
	private static final Logger logger = Logger.getLogger(PujaOrderDetailsController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private PujaOrderDetailsService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/pujaorderdetails")
	public PasupuKumkumaResponse createUser(PujaOrderDetailsReq req) {

		service.savePujaOrderDetails(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("PujaOrderDetails saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/pujaorderdetails/{pujaorderdetailsId}")
	public PasupuKumkumaResponse updateUser(@PathParam("pujaorderdetailsId") String pujaorderdetailsId, PujaOrderDetailsReq req) {

		service.updatePujaOrderDetails(req, pujaorderdetailsId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("PujaOrderDetails updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@GET
	@Path("/pujaorderdetails")
	public PasupuKumkumaResponse getUsers() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPujaOrderDetails());
		pasupuKumkumaResponse.setMessage("PujaOrderDetails fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@GET
	@Path("/pujaorderdetails/{pujaorderdetailsId}")
	public PasupuKumkumaResponse getUser(@PathParam("pujaorderdetailsId") String pujaorderdetailsId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPujaOrderDetails(pujaorderdetailsId));
		pasupuKumkumaResponse.setMessage("PujaOrderDetails fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@DELETE
	@Path("/pujaorderdetails/{pujaorderdetailsId}")
	public PasupuKumkumaResponse deleteRole(@PathParam("pujaorderdetailsId") String pujaorderdetailsId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if (service.deletePujaOrderDetails(pujaorderdetailsId)) {
			pasupuKumkumaResponse.setMessage("PujaOrderDetails deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the PujaOrderDetails");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return pasupuKumkumaResponse;

	}


}
