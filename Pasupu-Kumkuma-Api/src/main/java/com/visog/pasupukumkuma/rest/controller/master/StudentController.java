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
import com.visog.pasupukumkuma.req.StudentReq;
import com.visog.pasupukumkuma.res.PasupuKumkumaResponse;
import com.visog.pasupukumkuma.service.master.RolesService;
import com.visog.pasupukumkuma.service.master.StudentService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class StudentController {

	private static final Logger logger = Logger.getLogger(RolesController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private StudentService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/students")
	public PasupuKumkumaResponse createStudent(StudentReq req) {

		service.saveStudent(req);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Student saved succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;
	
		
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/students/{studentId}")
	public PasupuKumkumaResponse updateRole(@PathParam("studentId") String studentId, StudentReq req) {

		service.updateStudent(req, studentId);

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setMessage("Student updated succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;
	}
	@GET
	@Path("/students")
	public PasupuKumkumaResponse getStudents() {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getStudent());
		pasupuKumkumaResponse.setMessage("Student fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	@GET
	@Path("/student/{studentId}")
	public PasupuKumkumaResponse getStudent(@PathParam("studentId") String studentId) {

		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();
		pasupuKumkumaResponse.setData(service.getStudent(studentId));
		pasupuKumkumaResponse.setMessage("Student fetched succcessfully");
		pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
		pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return pasupuKumkumaResponse;

	}
	@DELETE
	@Path("/student/{studentId}")
	public PasupuKumkumaResponse deleteStudent(@PathParam("studentId") String studentId) {
		
		PasupuKumkumaResponse pasupuKumkumaResponse = new PasupuKumkumaResponse();

		if(service.deleteStudent(studentId)) {
			pasupuKumkumaResponse.setMessage("Student deleted succcessfully");
			pasupuKumkumaResponse.setStatus(Status.STATUS_SUCCESS);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			pasupuKumkumaResponse.setMessage("Failed to delete he role");
			pasupuKumkumaResponse.setStatus(Status.STATUS_FAIL);
			pasupuKumkumaResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return pasupuKumkumaResponse;
	
	
	}
	
}
