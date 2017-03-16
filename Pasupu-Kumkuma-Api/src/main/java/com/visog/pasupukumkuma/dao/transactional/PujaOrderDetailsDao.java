package com.visog.pasupukumkuma.dao.transactional;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transactional.PujaOrderDetails;

public interface PujaOrderDetailsDao extends AbstractDaoI {
	
	public List<PujaOrderDetails> getPujaOrderDetails();
	
}
