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
import com.visog.pasupukumkuma.req.CouponTypeReq;
import com.visog.pasupukumkuma.req.PujaSamagriReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.CouponTypeService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class CouponTypeController {

	private static final Logger logger = Logger.getLogger(CouponTypeController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private CouponTypeService service;

	/**
	 * This method creates the CouponType
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/coupon_type")
	public PasupuKumkumaResponse createCouponType(CouponTypeReq req) {

		service.saveCouponType(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("CouponType saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method updates the CouponType
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/coupon_type/{COUPON_TYPE_ID}")
	public PasupuKumkumaResponse updateCouponType(@PathParam("coupontypeId") String coupontypeId, CouponTypeReq req) {

		service.updateCouponType(req, coupontypeId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("CouponType updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method retrieves all coupontypes
	 * 
	 * @return
	 */
	@GET
	@Path("/coupon_type")
	public PasupuKumkumaResponse getCouponType() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCouponType());
		pasupuKumkumaResponse.setMessage("CouponType fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	/**
	 * This method retrieves a single CouponType
	 * 
	 * @return
	 */

	@GET
	@Path("/coupon_type/{COUPON_TYPE_ID}")
	public PasupuKumkumaResponse getCouponType(@PathParam("coupontypeId") String coupontypeId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getCouponType(coupontypeId));
		pasupuKumkumaResponse.setMessage("CouponType fetched succcessfully");
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
	@Path("/coupon_type/{COUPON_TYPE_ID}")
	public PasupuKumkumaResponse deleteCouponType(@PathParam("coupontypeId") String coupontypeId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if (service.deleteCouponType(coupontypeId)) {
			pasupuKumkumaResponse.setMessage("CouponType deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he coupontype");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return pasupuKumkumaResponse;

	}

}
