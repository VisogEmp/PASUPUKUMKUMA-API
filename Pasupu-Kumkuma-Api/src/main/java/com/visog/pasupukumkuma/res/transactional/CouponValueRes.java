package com.visog.pasupukumkuma.res.transactional;

public class CouponValueRes {
	
  private String id;
  
  private Double amount;
  
  private String couponType;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}


public String getCouponType() {
	return couponType;
}

public void setCouponType(String couponType) {
	this.couponType = couponType;
}

public Double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}
  

}
