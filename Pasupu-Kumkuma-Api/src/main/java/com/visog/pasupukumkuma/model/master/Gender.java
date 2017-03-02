package com.visog.pasupukumkuma.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.visog.pasupukumkuma.model.AbstractModel;


@Table(name ="GENDER")
@Entity
public class Gender extends AbstractModel {

	@Id
	@Column(name ="ID")
	private String id;
	
	@Column(name ="NAME")
	 private String name;
	
	
	@Column(name ="DESCRIPTION")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
