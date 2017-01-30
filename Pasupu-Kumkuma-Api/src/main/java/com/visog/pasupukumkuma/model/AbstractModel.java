package com.visog.pasupukumkuma.model;

import java.util.Date;

public abstract class AbstractModel {

	private String id;

	private String createdBy;

	private Date createdOn;

	private String updatedBy;

	private Date updatedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
