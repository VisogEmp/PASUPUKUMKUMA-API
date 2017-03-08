package com.visog.pasupukumkuma.service.transaction;

import java.util.List;

import com.visog.pasupukumkuma.req.transaction.UsersReq;
import com.visog.pasupukumkuma.res.transaction.UsersRes;

public interface UsersService {
	
public void saveUser(UsersReq req);
	
	public void updateUser(UsersReq req, String usersId);
	
	public List<UsersRes> getUsers();
	
	public UsersRes getUser(String id);
	
	public Boolean deleteUser(String usersId);

}
