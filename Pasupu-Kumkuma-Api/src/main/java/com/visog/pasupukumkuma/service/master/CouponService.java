package com.visog.pasupukumkuma.service.master;

import com.visog.pasupukumkuma.req.CouponReq;
import com.visog.pasupukumkuma.res.CouponRes;


public interface CouponService {
	public void saveCoupon(CouponReq req);	
	
	public void updateCoupon(CouponReq req, String couponId);
	
	public java.util.List<CouponRes> getCoupons();
	
	public CouponRes getcoupon(String id);
	
	public Boolean deletecoupon(String couponId);
}
