package com.visog.pasupukumkuma.req;

public class PujaReq {
	
	private String name;
	
	private String description;
	
	private String price;
	
	private String duration;
	
	private Integer pujaCount;
	
	private String photo;
	
	private String status;

	
	public Integer getPujaCount() {
		return pujaCount;
	}

	public void setPujaCount(Integer pujaCount) {
		this.pujaCount = pujaCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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
	
	

}
