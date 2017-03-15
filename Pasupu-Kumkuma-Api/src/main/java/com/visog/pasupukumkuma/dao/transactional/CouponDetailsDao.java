package com.visog.pasupukumkuma.dao.transactional;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transactional.CouponDetails;

public interface CouponDetailsDao extends AbstractDaoI {

	public List<CouponDetails> getCouponDetails();
}
