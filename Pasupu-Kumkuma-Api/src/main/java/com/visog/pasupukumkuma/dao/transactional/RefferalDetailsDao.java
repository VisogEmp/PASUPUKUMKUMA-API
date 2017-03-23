package com.visog.pasupukumkuma.dao.transactional;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transactional.RefferalDetails;

public interface RefferalDetailsDao extends AbstractDaoI {
	
	public List<RefferalDetails> getRefferalDetails();
	

}
