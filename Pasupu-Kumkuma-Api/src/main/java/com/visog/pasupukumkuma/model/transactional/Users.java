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
import com.visog.pasupukumkuma.model.master.Gender;
import com.visog.pasupukumkuma.model.master.Nakshatram;
import com.visog.pasupukumkuma.model.master.Raasi;
import com.visog.pasupukumkuma.model.master.Roles;
import com.visog.pasupukumkuma.model.master.Status;

@Table(name = "USERS")
@Entity
public class Users extends AbstractModel {

	@Id
	@Column(name = "ID")
	private String id;

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Roles role;

	@ManyToOne
	@JoinColumn(name = "GENDER_ID")
	private Gender gender;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = " ALTERNATIVE_EMAIL")
	private String alternativeEmail;

	@Column(name = " PASSWORD")
	private String password;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "DOB")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	@Column(name = "BIRTH_PLACE")
	private String birthPlace;

	@Column(name = "BIRTH_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthTime;

	@ManyToOne
	@JoinColumn(name = "RAASI_ID")
	private Raasi raasi;

	@ManyToOne
	@JoinColumn(name = "NAKSHATRAM_ID")
	private Nakshatram nakshatram;

	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlternativeEmail() {
		return alternativeEmail;
	}

	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(Date birthTime) {
		this.birthTime = birthTime;
	}

	public Raasi getRaasi() {
		return raasi;
	}

	public void setRaasi(Raasi raasi) {
		this.raasi = raasi;
	}

	public Nakshatram getNakshatram() {
		return nakshatram;
	}

	public void setNakshatram(Nakshatram nakshatram) {
		this.nakshatram = nakshatram;
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

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
