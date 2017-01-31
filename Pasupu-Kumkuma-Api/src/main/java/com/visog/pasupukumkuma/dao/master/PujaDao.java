package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Puja;

public interface PujaDao extends AbstractDaoI {
	
	public List<Puja> getPujas();
	
	

}
