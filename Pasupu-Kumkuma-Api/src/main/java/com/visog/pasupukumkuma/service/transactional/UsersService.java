package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.UsersReq;
import com.visog.pasupukumkuma.res.transactional.UsersRes;


public interface UsersService {
	
     public void saveUser(UsersReq req);
	
	public void updateUser(UsersReq req, String usersId);
	
	public List<UsersRes> getUsers();
	
	public UsersRes getUser(String id);
	
	public Boolean deleteUser(String usersId);

}