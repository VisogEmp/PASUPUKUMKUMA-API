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
import com.visog.pasupukumkuma.model.master.CouponType;

@Table(name = "COUPON_VALUE")
@Entity

public class CouponValue extends AbstractModel {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "AMOUNT")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="COUPON_TYPE_ID")
	private CouponType couponType;

	
	@Column(name="CREATED_BY")
	private String createdby;
	
	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdon;
	
	@Column(name="UPDATED_BY")
	private String updatedby;
	
	@Column(name="UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	

	public CouponType getCouponType() {
		return couponType;
	}

	public void setCouponType(CouponType couponType) {
		this.couponType = couponType;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(Date updatedon) {
		this.updatedon = updatedon;
	}
	
  

	
	
	
}
