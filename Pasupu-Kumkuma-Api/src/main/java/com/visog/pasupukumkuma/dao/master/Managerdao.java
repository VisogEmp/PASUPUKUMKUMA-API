package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Manager;

public interface Managerdao extends AbstractDaoI {
	
	public List<Manager> getManagers();

}
