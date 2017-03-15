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
import com.visog.pasupukumkuma.req.transactional.CouponValueReq;
import com.visog.pasupukumkuma.req.transactional.UserRequestReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transactional.CouponValueService;

@Path("/transactional")
@Produces(MediaType.APPLICATION_JSON)
public class CouponValueController {

	public static final Logger logger = Logger.getLogger(UserRequestController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	CouponValueService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/couponvalue")

	public PasupuKumkumaResponse createCouponValue(CouponValueReq req) {
		service.savecouponValue(req);
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("UserRequest saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;
	}
      @PUT
      @Consumes(MediaType.APPLICATION_JSON)
      @Path("/couponvalue/{COUPAN_VALUE_ID}")
	public PasupuKumkumaResponse PasupuKumkumaResponseupdateCouponValue(@PathParam("COUPAN_VALUE_ID") String couponValueId, CouponValueReq req) {

		service.deletecouponValue(couponValueId);
		

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("couponValue updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;
	
	}

	@GET
	@Path("/couponValue")
	public PasupuKumkumaResponse getUserRequests() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCouponValues());
		pasupuKumkumaResponse.setMessage("couponValue fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}


	@GET
	@Path("/couponValue/{COUPAN_VALUE_ID}")
	public PasupuKumkumaResponse getCouponValues(@PathParam("COUPAN_VALUE_ID") String couponValueId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getcouponValues(couponValueId));
		pasupuKumkumaResponse.setMessage("couponValue fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	
	@DELETE
	@Path("/couponvalues/{COUPAN_VALUE_ID}")
	public PasupuKumkumaResponse deleteCouponValues(@PathParam("COUPAN_VALUE_ID") String couponValueId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deletecouponValue(couponValueId)) {
			pasupuKumkumaResponse.setMessage("couponValue deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the couponValue");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	}
}
