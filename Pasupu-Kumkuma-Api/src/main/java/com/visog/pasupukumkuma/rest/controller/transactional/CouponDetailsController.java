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
import com.visog.pasupukumkuma.req.transactional.CouponDetailsReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transactional.CouponDetailsService;

@Path("/transactional")
@Produces(MediaType.APPLICATION_JSON)
public class CouponDetailsController {
	
	private static final Logger logger = Logger.getLogger(CouponDetailsController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private CouponDetailsService service;

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/coupondetails")
	public PasupuKumkumaResponse createCouponDetails(CouponDetailsReq req) {

		service.saveCouponDetails(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Coupon details saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/coupondetails/{coupondetailsId}")
	public PasupuKumkumaResponse updateCouponDetails(@PathParam("coupondetailsId") String couponId, CouponDetailsReq req) {

		service.updateCouponDetail(req, couponId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("coupon details updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	@GET
	@Path("/coupondetails")
	public PasupuKumkumaResponse getCouponDetails() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCouponDetails());
		pasupuKumkumaResponse.setMessage("coupon details fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}


	@GET
	@Path("/coupondetails/{coupondetailsId}")
	public PasupuKumkumaResponse getCartOrder(@PathParam("coupondetailsId") String coupondetailsId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCouponDetail(coupondetailsId));
		pasupuKumkumaResponse.setMessage("coupon details fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@DELETE
	@Path("/coupondetails/{coupondetailsId}")
	public PasupuKumkumaResponse deleteCouponDetails(@PathParam("coupondetailsId") String coupondetailsId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteCouponDetail(coupondetailsId)) {
			pasupuKumkumaResponse.setMessage("coupon details deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he coupon details");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}

}
