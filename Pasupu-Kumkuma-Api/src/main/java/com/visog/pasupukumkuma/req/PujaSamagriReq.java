package com.visog.pasupukumkuma.req;

public class PujaSamagriReq {

	private String name;
	
	private String description;
	
	private Double price;
	
	private String duration;
	
	private String photo;
	
	private Integer samagri_count;
	
	private String status;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getSamagri_count() {
		return samagri_count;
	}

	public void setSamagri_count(Integer samagri_count) {
		this.samagri_count = samagri_count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
