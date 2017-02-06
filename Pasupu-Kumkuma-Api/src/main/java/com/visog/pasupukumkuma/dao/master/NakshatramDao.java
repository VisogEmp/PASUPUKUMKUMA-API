package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Nakshatram;

public interface NakshatramDao extends AbstractDaoI {
	
	public List<Nakshatram> getNakshatram(); 

}
