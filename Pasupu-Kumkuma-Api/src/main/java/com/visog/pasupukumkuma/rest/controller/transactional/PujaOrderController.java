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
import com.visog.pasupukumkuma.req.transactional.PujaOrderReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transactional.PujaOrderService;



@Path("/transactional")
@Produces(MediaType.APPLICATION_JSON)

public class PujaOrderController {

	private static final Logger logger = Logger.getLogger(PujaOrderController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private PujaOrderService service;

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/pujaorder")
	public PasupuKumkumaResponse createPujaOrder(PujaOrderReq req) {

		service.savePujaOrder(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("pujaorder saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/pujaorder/{pujaOrderId}")
	public PasupuKumkumaResponse updatePujaOrder(@PathParam("pujaOrderId") String pujaOrderId, PujaOrderReq req) {

		service.updatePujaOrder(req, pujaOrderId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("pujaOrder updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	
	@GET
	@Path("/pujaorder")
	public PasupuKumkumaResponse getPujaOrder() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPujaOrder());
		pasupuKumkumaResponse.setMessage("pujaOrder fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}


	@GET
	@Path("/pujaorder/{pujaOrderId}")
	public PasupuKumkumaResponse getPujaOrder(@PathParam("pujaOrderId") String pujaOrderId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPujaOrder(pujaOrderId));
		pasupuKumkumaResponse.setMessage("pujaorder fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	

	
	@DELETE
	@Path("/pujaorder/{pujaOrderId}")
	public PasupuKumkumaResponse deletePujaOrder(@PathParam("pujaOrderId") String pujaOrderId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deletePujaOrder(pujaOrderId)) {
			pasupuKumkumaResponse.setMessage("pujaorder deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he pujaorder");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}
	
}
