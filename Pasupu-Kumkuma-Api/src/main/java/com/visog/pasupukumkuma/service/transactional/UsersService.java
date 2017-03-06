package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.UsersReq;
import com.visog.pasupukumkuma.res.transactional.UsersRes;

public interface UsersService {
	
	    public Boolean saveUsers(UsersReq req);
		
		public Boolean updateUsers(UsersReq req, String usersId);
		
		public List<UsersRes> getUsers();
		
		public UsersRes getUsers(String id);
		
		public Boolean deleteUsers(String usersId);


}
