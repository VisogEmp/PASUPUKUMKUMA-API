package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Roles;

public interface RoleDao extends AbstractDaoI {
	
	public List<Roles> getRoles();
	
}
