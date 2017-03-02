package com.visog.pasupukumkuma.dao.transactional;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transactional.Users;

public interface UsersDao extends AbstractDaoI{
	
    public List<Users> getUsers();
	
	public Boolean isUsersExists(String name);

}
