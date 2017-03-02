package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.StateReq;
import com.visog.pasupukumkuma.res.StateRes;

public interface UsersService {
	
	 public Boolean saveUsers(StateReq req);
		
		public Boolean updateUsers(StateReq req, String stateId);
		
		public List<StateRes> getUsers();
		
		public StateRes getUsers(String id);
		
		public Boolean deleteUsers(String stateId);


}
