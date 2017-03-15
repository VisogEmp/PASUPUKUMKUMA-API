package com.visog.pasupukumkuma.req.transactional;

public class CouponValueReq {
	
	private Double amount;
	
	private String couponType;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}
	

}
