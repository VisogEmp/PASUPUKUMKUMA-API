package com.visog.pasupukumkuma.dao.transactional;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transactional.CouponValue;

public interface CouponValueDao extends AbstractDaoI {
	
	public List<CouponValue> getCouponValues();
	
	
	

}
