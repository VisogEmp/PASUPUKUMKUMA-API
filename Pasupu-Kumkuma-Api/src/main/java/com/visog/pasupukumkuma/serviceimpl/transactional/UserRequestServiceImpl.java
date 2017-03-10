package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.UserRequestDao;
import com.visog.pasupukumkuma.model.transactional.UserRequest;
import com.visog.pasupukumkuma.model.transactional.Users;
import com.visog.pasupukumkuma.req.transactional.UserRequestReq;
import com.visog.pasupukumkuma.res.transactional.UserRequestRes;
import com.visog.pasupukumkuma.service.transactional.UserRequestService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class UserRequestServiceImpl implements UserRequestService{
	
	private static final Logger logger=Logger.getLogger(UserRequestServiceImpl.class);
	
	
	@Inject
	private UserRequestDao dao;
	
	

	public void saveUserRequests(UserRequestReq req) {
		
		UserRequest userRequest = new UserRequest();
		
		Users user=new Users();
		user.setId(req.getRequest());
		userRequest.setRequest(user);
		
		userRequest.setSubject(req.getSubject());
		userRequest.setMessage(req.getMessage());
		/*
		Users user=new Users();
		user.setId(req.getRequest());
		userRequest.setRequest(user);*/
		
		
		DaoUtils.setEntityCreateAuditColumns(userRequest);
		
         dao.save(userRequest);
         logger.info(" UserRequest created successfully : " + userRequest.getId());
		
		
	}

	
	public void updateUserRequests(UserRequestReq req, String UserRequestId) {
		
        UserRequest userRequest =(UserRequest) dao.getByKey(UserRequest.class, UserRequestId);
		
		userRequest.setSubject(req.getSubject());
		userRequest.setMessage(req.getMessage());
		
		Users user=new Users();
		user.setId(req.getRequest());
		userRequest.setRequest(user);
		
		dao.update(userRequest);
		
		logger.info("UserRequest  updated succesfully"+userRequest.getId());
		
	}
	public List<UserRequestRes> getUserRequests() {
		List<UserRequest> useRequest = dao.getUserRequests();

		List<UserRequestRes> userRequestList = new ArrayList<>();
		UserRequestRes userRequestRes = null;

		
		for (UserRequest userRequests : useRequest) {
			
			userRequestRes = new UserRequestRes();
			userRequestRes.setId(userRequests.getId());
			userRequestRes.setSubject(userRequests.getSubject());
			userRequestRes.setMessage(userRequests.getMessage());
			userRequestRes.setRequest(userRequests.getRequest().getId());
			
			userRequestList.add(userRequestRes);
		}
		return userRequestList;
		
	}

	public UserRequestRes getUserRequests(String id) {
		
		 UserRequest  userRequest =( UserRequest) dao.getByKey(UserRequest.class, id);
		 UserRequestRes  userRequestRes= new  UserRequestRes();
		 userRequestRes.setId(userRequest.getId());
	     userRequestRes.setSubject(userRequest.getSubject());
	     userRequestRes.setMessage(userRequest.getMessage());
	     
	     userRequestRes.setRequest(userRequest.getRequest().getId());
	     return userRequestRes;
	}
		

	public Boolean deleteUserRequests(String userRequestId) {
		
	return (dao.delete(UserRequest.class, userRequestId)!=0);
	}

	
	
	

}
