package com.visog.pasupukumkuma.dao.transaction;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transaction.Users;

public interface UsersDao extends AbstractDaoI  {

	public List<Users> getUsers();
}
