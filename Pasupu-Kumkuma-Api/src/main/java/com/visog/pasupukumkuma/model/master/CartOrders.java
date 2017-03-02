package com.visog.pasupukumkuma.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.visog.pasupukumkuma.model.AbstractModel;

@Table(name = "cart_orders")
@Entity

public class CartOrders extends AbstractModel {

	@Id
	@Column(name = "ID")
	private String id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users userid;

	@ManyToOne
	@JoinColumn(name = "PUJA_ID")
	private Puja pujaid;

	
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getUserid() {
		return userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}

	public Puja getPujaid() {
		return pujaid;
	}

	public void setPujaid(Puja pujaid) {
		this.pujaid = pujaid;
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
