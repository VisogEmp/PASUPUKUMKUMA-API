package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.State;

public interface StateDao extends AbstractDaoI {

	public List<State> getState();
	
	public Boolean isStateExists(String name);
}
