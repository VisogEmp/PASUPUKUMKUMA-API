package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Pujas;

public interface PujasDao extends AbstractDaoI {
	
	public List<Pujas> getPujas();
	
	

}
