package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.CouponValueReq;
import com.visog.pasupukumkuma.res.transactional.CouponValueRes;

public interface CouponValueService {

	public void savecouponValue(CouponValueReq req);
	
	public void UpdatecouponValue(CouponValueReq req, String CouponValueId);
	
	public List<CouponValueRes> getCouponValues();
	
	public   CouponValueRes getcouponValues(String id);
	
	public Boolean deletecouponValue(String couponValueId);
}
