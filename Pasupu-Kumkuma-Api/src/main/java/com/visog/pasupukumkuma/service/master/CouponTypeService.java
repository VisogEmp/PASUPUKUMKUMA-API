package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.CouponTypeReq;
import com.visog.pasupukumkuma.res.CouponTypeRes;


public interface CouponTypeService {
	
public void saveCouponType(CouponTypeReq req);
	
	public void updateCouponType(CouponTypeReq req, String coupontypeId);
	
    public List<CouponTypeRes> getCouponType();
	
	public CouponTypeRes getCouponType(String id);
	
	public Boolean deleteCouponType(String coupontypeId);


}
