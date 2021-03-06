package com.visog.pasupukumkuma.res;

public class AccessLinksResponse {

	private Long id;
	private String name;
	private String displayName;
	private String description;
	private String parent;
	private Boolean otp;
	private String otpMedia;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public Boolean getOtp() {
		return otp;
	}
	public void setOtp(Boolean otp) {
		this.otp = otp;
	}
	public String getOtpMedia() {
		return otpMedia;
	}
	public void setOtpMedia(String otpMedia) {
		this.otpMedia = otpMedia;
	}

	
}
