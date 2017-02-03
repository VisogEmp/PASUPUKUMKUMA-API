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

@Table(name ="puja_samagri_PUJA")
@Entity
public class PujaSamagriPuja extends AbstractModel {

	@Id
	@Column(name ="ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="PUJASAMAGRI_ID")
	private PujaSamagri pujasamagri;
	
	@ManyToOne
	@JoinColumn(name="PUJAS_ID")
	private Puja pujas;
	
	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;
	
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

	public Date getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public PujaSamagri getPujasamagri() {
		return pujasamagri;
	}


	public void setPujasamagri(PujaSamagri pujasamagri) {
		this.pujasamagri = pujasamagri;
	}


	public Puja getPujas() {
		return pujas;
	}


	public void setPujas(Puja pujas) {
		this.pujas = pujas;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
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
	
	

}
