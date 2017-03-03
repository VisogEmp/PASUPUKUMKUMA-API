package com.visog.pasupukumkuma.dao.transactional;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transactional.CartOrders;
import com.visog.pasupukumkuma.res.transactional.CartOrdersRes;

public interface CartOrdersDao extends AbstractDaoI {
	
	public List<CartOrders> getCartOrders();
	
}
