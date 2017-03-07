package com.visog.pasupukumkuma.req.transactional;

import com.visog.pasupukumkuma.model.master.Status;

public class PujaOrderReq {
	
	private String userId;
	
	private String pujaId;
	
	private String ammount;
	
	private String payed;
	
	private Status statusId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPujaId() {
		return pujaId;
	}

	public void setPujaId(String pujaId) {
		this.pujaId = pujaId;
	}

	public String getAmmount() {
		return ammount;
	}

	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}

	public String getPayed() {
		return payed;
	}

	public void setPayed(String payed) {
		this.payed = payed;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}
	
	

}
