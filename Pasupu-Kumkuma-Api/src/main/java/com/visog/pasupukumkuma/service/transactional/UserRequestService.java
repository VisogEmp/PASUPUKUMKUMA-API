package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.UserRequestReq;
import com.visog.pasupukumkuma.res.transactional.UserRequestRes;


public interface UserRequestService {

	
	public void saveUserRequests(UserRequestReq req);
	
	public void updateUserRequests(UserRequestReq req, String UserRequestId);
	
	public List<UserRequestRes> getUserRequests();
	
	public UserRequestRes getUserRequests(String id);
	
	public Boolean deleteUserRequests(String UsersId);
	
	
	
}
