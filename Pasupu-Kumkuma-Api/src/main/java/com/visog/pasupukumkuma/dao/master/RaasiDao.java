package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Raasi;

public interface RaasiDao extends AbstractDaoI {
	
	public List<Raasi> getRaasi();
	
}
