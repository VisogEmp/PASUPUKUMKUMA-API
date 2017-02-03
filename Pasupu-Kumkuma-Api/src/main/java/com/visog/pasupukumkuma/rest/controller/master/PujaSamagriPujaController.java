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
import com.visog.pasupukumkuma.req.PujaSamagriPujaReq;
import com.visog.pasupukumkuma.req.StateReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.PujaSamagriPujaService;
import com.visog.pasupukumkuma.service.master.StateService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class PujaSamagriPujaController {

	private static final Logger logger = Logger.getLogger(PujaSamagriPujaController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private PujaSamagriPujaService service;
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/puja_samagri_puja")
	public PasupuKumkumaResponse createPujaSamagriPuja(PujaSamagriPujaReq req) {

		service.savePujaSamagriPuja(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("PujaSamagriPuja saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/puja_samagri_puja/{PUJA_SAMAGRI_PUJA_ID}")
	public PasupuKumkumaResponse updatePujaSamagriPuja(@PathParam("PUJA_SAMAGRI_PUJA_ID") PujaSamagriPujaReq req ,String pujaSamgriPujaId ) {

		service.updatePujaSamagriPuja(req, pujaSamgriPujaId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("pujasamgripuja updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	@GET
	@Path("/pujas")
	public PasupuKumkumaResponse getPujaSamagriPuja() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPujaSamagriPuja());
		pasupuKumkumaResponse.setMessage("pujasamgripuja fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;
	}
	@GET
	@Path("/puja_samagri_puja/{PUJA_SAMAGRI_PUJA_ID}")
	public PasupuKumkumaResponse getPujaSamgriPuja(@PathParam("PUJA_SAMAGRI_PUJA_ID") String pujasamgripujaId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getPujaSamagriPuja(pujasamgripujaId));
		pasupuKumkumaResponse.setMessage("pujasamgripuja fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	@DELETE
	@Path("/stapuja_samagri_pujate/{PUJA_SAMAGRI_PUJA_ID}")
	public PasupuKumkumaResponse deleteRole(@PathParam("PUJA_SAMAGRI_PUJA_ID") String pujasamagripujaId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deletePujaSamagriPuja(pujasamagripujaId)) {
			pasupuKumkumaResponse.setMessage("pujasamagripuja deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete the pujasamagripuja");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}
	
}
