package com.visog.pasupukumkuma.model.transactional;

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

@Table(name ="REFERAL_DETAILS")
@Entity

public class RefferalDetails extends AbstractModel {
	
	@Id
	@Column(name ="ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name ="REFERREDBY")
	private Users referredBy;
	
	@Column(name ="REFERRED_TO_EMAIL")
	private String referredToEmail;
	
	@Column(name ="COUPAN_CODE")
	private String couponCode;
	
	@Column(name ="REFERAL_STATE_ID")
	private String referalStateId;
	
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

	public Users getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(Users referredBy) {
		this.referredBy = referredBy;
	}

	public String getReferredToEmail() {
		return referredToEmail;
	}

	public void setReferredToEmail(String referredToEmail) {
		this.referredToEmail = referredToEmail;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getReferalStateId() {
		return referalStateId;
	}

	public void setReferalStateId(String referalStateId) {
		this.referalStateId = referalStateId;
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
