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
import com.visog.pasupukumkuma.req.RolesReq;
import com.visog.pasupukumkuma.req.transactional.CartOrdersReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.rest.controller.master.RolesController;
import com.visog.pasupukumkuma.service.master.RolesService;
import com.visog.pasupukumkuma.service.transactional.CartOrdersService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class CartOrdersController {
	
	private static final Logger logger = Logger.getLogger(CartOrdersController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private CartOrdersService service;

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CartOrders")
	public PasupuKumkumaResponse createCartOrders(CartOrdersReq req) {

		service.saveCartOrders(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("CartOrders saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cartorders/{userId}")
	public PasupuKumkumaResponse updateCartOrders(@PathParam("userId") String userId, CartOrdersReq req) {

		service.updateCartOrders(req, userId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("CartOrder updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	
	@GET
	@Path("/cartorders")
	public PasupuKumkumaResponse getCartOrders() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCartOrders());
		pasupuKumkumaResponse.setMessage("CartOrders fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}


	@GET
	@Path("/cartorder/{userId}")
	public PasupuKumkumaResponse getCartOrder(@PathParam("userId") String userId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCartOrder(userId));
		pasupuKumkumaResponse.setMessage("cartorders fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	

	
	@DELETE
	@Path("/cartorders/{userId}")
	public PasupuKumkumaResponse deleteCartOrders(@PathParam("userId") String userId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteCartOrders(userId)) {
			pasupuKumkumaResponse.setMessage("cartorder deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he cart orders");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}

}
