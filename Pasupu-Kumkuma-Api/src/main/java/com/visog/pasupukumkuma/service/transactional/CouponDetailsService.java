package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.CouponDetailsReq;
import com.visog.pasupukumkuma.res.transactional.CouponDetailsRes;


public interface CouponDetailsService {

	public void saveCouponDetails(CouponDetailsReq req);
	
	public void updateCouponDetail(CouponDetailsReq req, String couponId);
	
	public List<CouponDetailsRes> getCouponDetails();
	
	public CouponDetailsRes getCouponDetail(String id);
	
	public Boolean deleteCouponDetail(String couponId);
}
