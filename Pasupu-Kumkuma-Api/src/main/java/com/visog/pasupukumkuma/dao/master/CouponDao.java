package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Coupon;

public interface CouponDao extends AbstractDaoI {
	
	public List<Coupon> getCoupon();
	
}
