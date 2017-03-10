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
import com.visog.pasupukumkuma.model.master.City;
import com.visog.pasupukumkuma.model.master.Country;
import com.visog.pasupukumkuma.model.master.State;

@Table(name ="ADDRESS")
@Entity
public class Address extends AbstractModel{
	
	@Id
	@Column(name ="ID")
	private String id;
	
	@Column(name ="ADDRESS_LINE1")
	private String addressLine1;
	
	@Column(name ="ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name ="ZIPCODE")
	private String zipcode;
	
	@ManyToOne
	@JoinColumn(name ="STATE_ID")
	private State state;
	
	@ManyToOne
	@JoinColumn(name ="USER_ID")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name ="CITY_ID")
	private City city;
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne
	@JoinColumn(name ="COUNTRY_ID")
	private Country country;
	
	
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
