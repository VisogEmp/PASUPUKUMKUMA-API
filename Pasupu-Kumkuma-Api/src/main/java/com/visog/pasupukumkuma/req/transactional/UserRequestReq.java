package com.visog.pasupukumkuma.req.transactional;


public class UserRequestReq {
	
	 private String request;  
	
	 private String subject;	
	 
	 private String message; 
	 
	 

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
