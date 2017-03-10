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
import com.visog.pasupukumkuma.req.transactional.AddressReq;
import com.visog.pasupukumkuma.req.transactional.UsersReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.transactional.AddressService;
import com.visog.pasupukumkuma.service.transactional.UsersService;

@Path("/transactional")
@Produces(MediaType.APPLICATION_JSON)
public class AddressController {
	
	private static final Logger logger = Logger.getLogger(AddressController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private AddressService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/address")
	public PasupuKumkumaResponse createUsers(AddressReq req) {

		service.saveAddress(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Address saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/address/{ADDRESS_ID}")
	public PasupuKumkumaResponse updateAddress(@PathParam("ADDRESS_ID") String addressId, AddressReq req) {

		service.updateAddress(req, addressId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("address updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;
	}
	
	@GET
	@Path("/address")
	public PasupuKumkumaResponse getAddress() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getAddress());
		pasupuKumkumaResponse.setMessage("address fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@GET
	@Path("/address/{ADDRESS_ID}")
	public PasupuKumkumaResponse getAddress(@PathParam("ADDRESS_ID") String addressId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getAddress(addressId));
		pasupuKumkumaResponse.setMessage("address fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@DELETE
	@Path("/address/{ADDRESS_ID}")
	public PasupuKumkumaResponse deleteAddress(@PathParam("ADDRESS_ID") String addressId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteAddress(addressId)) {
			pasupuKumkumaResponse.setMessage("address deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the address");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}

}
