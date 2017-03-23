package com.visog.pasupukumkuma.req.transactional;


public class RefferalDetailsReq {
	
	private String referredBy;
	
	private String referredToEmail;
	
	private String couponCode;
	
	private String referalStateId;

	
	
	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getReferredToEmail() {
		return referredToEmail;
	}

	public void setReferredToEmail(String referredToEmail) {
		this.referredToEmail = referredToEmail;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getReferalStateId() {
		return referalStateId;
	}

	public void setReferalStateId(String referalStateId) {
		this.referalStateId = referalStateId;
	}


	
	

}
