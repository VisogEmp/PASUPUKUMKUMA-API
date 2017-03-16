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
import com.visog.pasupukumkuma.model.master.PujaSamagri;

@Table(name = "PUJA_ORDERS_DETAILS")
@Entity
public class PujaOrderDetails extends AbstractModel {
	
	@Id
	@Column(name = "ID")
	private String id;

	@ManyToOne
	@JoinColumn(name = "PUJA_ORDER_ID")
	private PujaOrder pujaOrder;

	@ManyToOne
	@JoinColumn(name = "PUJA_SAMAGRI_ID")
	private PujaSamagri pujaSamagri;

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

	public PujaOrder getPujaOrder() {
		return pujaOrder;
	}

	public void setPujaOrder(PujaOrder pujaOrder) {
		this.pujaOrder = pujaOrder;
	}

	public PujaSamagri getPujaSamagri() {
		return pujaSamagri;
	}

	public void setPujaSamagri(PujaSamagri pujaSamagri) {
		this.pujaSamagri = pujaSamagri;
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
