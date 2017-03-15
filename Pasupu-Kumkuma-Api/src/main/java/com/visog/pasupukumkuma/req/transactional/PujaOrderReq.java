package com.visog.pasupukumkuma.req.transactional;


public class PujaOrderReq {
	
	private String user;
	
	private String puja;
	
	private Double amount;
	
	private Double payed;
	
	private String status;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPuja() {
		return puja;
	}

	public void setPuja(String puja) {
		this.puja = puja;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPayed() {
		return payed;
	}

	public void setPayed(Double payed) {
		this.payed = payed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

}
