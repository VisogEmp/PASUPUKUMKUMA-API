package com.visog.pasupukumkuma.dao.transactional;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transactional.PujaOrder;

public interface PujaOrderDao extends AbstractDaoI {
	
	public List <PujaOrder> getPujaOrder();
	
	
	
}
