package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.CouponType;

public interface CouponTypeDao extends AbstractDaoI {

	public List<CouponType> getCouponType();
}
