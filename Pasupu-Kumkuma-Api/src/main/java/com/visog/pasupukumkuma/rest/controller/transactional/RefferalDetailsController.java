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
import com.visog.pasupukumkuma.req.transactional.RefferalDetailsReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transactional.RefferalDetailsService;

@Path("/transactional")
@Produces(MediaType.APPLICATION_JSON)
public class RefferalDetailsController {
	
	private static final Logger logger = Logger.getLogger(RefferalDetailsController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private RefferalDetailsService service;

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/refferaldetails")
	public PasupuKumkumaResponse createRefferalDetails(RefferalDetailsReq req) {

		service.saveRefferalDetails(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("RefferalDetails saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/refferaldetails/{refferaldetailsId}")
	public PasupuKumkumaResponse updateCartOrders(@PathParam("refferaldetailsId") String userId, RefferalDetailsReq req) {

		service.updateRefferalDetails(req, userId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("RefferalDetails updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	
	@GET
	@Path("/refferaldetails")
	public PasupuKumkumaResponse getCartOrders() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getRefferalDetails());
		pasupuKumkumaResponse.setMessage("RefferalDetails fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}


	@GET
	@Path("/refferaldetails/{refferaldetailsId}")
	public PasupuKumkumaResponse getCartOrder(@PathParam("refferaldetailsId") String cartorderid) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getRefferalDetail(cartorderid));
		pasupuKumkumaResponse.setMessage("RefferalDetails fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	

	
	@DELETE
	@Path("/refferaldetails/{refferaldetailsId}")
	public PasupuKumkumaResponse deleteCartOrders(@PathParam("refferaldetailsId") String cartorderId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteRefferalDetail(cartorderId)) {
			pasupuKumkumaResponse.setMessage("RefferalDetails deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the RefferalDetails");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}


}
