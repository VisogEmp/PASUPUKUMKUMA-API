package com.visog.pasupukumkuma.model.transactional;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.visog.pasupukumkuma.model.AbstractModel;

@Table(name="CONTACT")
@Entity

public class Contact extends AbstractModel {
	
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NO")
	private String phoneno;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="QUERY")
	private String query;
	
	@Column(name="DATETIME")
	private String datetime;
	
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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
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
