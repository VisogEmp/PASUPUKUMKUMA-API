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
import com.visog.pasupukumkuma.req.CountryReq;
import com.visog.pasupukumkuma.req.transactional.ContactReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.rest.controller.master.CountryController;
import com.visog.pasupukumkuma.service.master.CountryService;
import com.visog.pasupukumkuma.service.transactional.ContactService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class ContactController {
	
	private static final Logger logger = Logger.getLogger(ContactController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private ContactService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/contact")
	public PasupuKumkumaResponse createContact(ContactReq req) {

		service.saveContact(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("contact saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/contact/{contactId}")
	public PasupuKumkumaResponse updateContact(@PathParam("contactId") String contactId, ContactReq req) {

		service.updateContact(req, contactId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("contact updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@GET
	@Path("/contact")
	public PasupuKumkumaResponse getContacts() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getContacts());
		pasupuKumkumaResponse.setMessage("contacts fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}

	@GET
	@Path("/contact/{contactId}")
	public PasupuKumkumaResponse getRole(@PathParam("contactId") String contactId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getContacts(contactId));
		pasupuKumkumaResponse.setMessage("contact fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	
	@DELETE
	@Path("/contact/{contactid}")
	public PasupuKumkumaResponse deleteRosle(@PathParam("contactid") String contactId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteContacts(contactId)) {
			pasupuKumkumaResponse.setMessage("contact deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the contact");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}

	




}
