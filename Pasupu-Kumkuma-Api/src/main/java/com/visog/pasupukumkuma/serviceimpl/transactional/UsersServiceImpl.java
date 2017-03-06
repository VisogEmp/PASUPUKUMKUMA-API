package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.UsersDao;
import com.visog.pasupukumkuma.model.master.Gender;
import com.visog.pasupukumkuma.model.master.Nakshatram;
import com.visog.pasupukumkuma.model.master.Raasi;
import com.visog.pasupukumkuma.model.master.Roles;
import com.visog.pasupukumkuma.model.master.Status;
import com.visog.pasupukumkuma.model.transactional.Users;
import com.visog.pasupukumkuma.req.transactional.UsersReq;
import com.visog.pasupukumkuma.res.transactional.UsersRes;
import com.visog.pasupukumkuma.service.transactional.UsersService;
import com.visog.pasupukumkuma.utils.DaoUtils;


public class UsersServiceImpl implements UsersService {

	private static final Logger logger = Logger.getLogger(UsersServiceImpl.class);
	
	@Inject
	private UsersDao dao;
	
	public Boolean saveUsers(UsersReq req) {

		Users user = new Users();
		user.setName(req.getName());
		user.setEmail(req.getEmail());
		user.setAlternativeEmail(req.getAlternativeEmail());
		user.setPassword(req.getPassword());
		user.setPhoneNo(req.getPhoneNo());
		user.setDob(req.getDob());
		user.setBirthPlace(req.getBirthPlace());
		user.setBirthTime(req.getBirthTime());
		
		Raasi raasi = new Raasi();
		raasi.setId(req.getRaasi());
		user.setRassi(raasi);
		
		Nakshatram nakshatram = new Nakshatram();
		nakshatram.setId(req.getNakshatram());
		user.setNakshatram(nakshatram);
		
		Roles role = new Roles();
		role.setId(req.getRole());
		user.setRole(role);
		
		Gender gender = new Gender();
		gender.setId(req.getGender());
		user.setGender(gender);
		
		Status status = new Status();
		status.setId(req.getStatus());
		user.setStatus(status);
		
		
		DaoUtils.setEntityCreateAuditColumns(user);

		if (dao.isUsersExists(req.getName())) {

			logger.info("user already exist : " + user.getId());
			return false;

		} else {
			dao.save(user);

			logger.info("user created successfully : " + user.getId());
			return true;

		}

	}
	
	/**
	 * This method updates the User
	 */
	public Boolean updateUsers(UsersReq req, String usersId) {

		Users user = (Users) dao.getByKey(Users.class, usersId);
		logger.info("user exist : " + user.getName().toLowerCase().trim());
		logger.info("user new : " + req.getName().toLowerCase().trim());

		if (user.getName().toLowerCase().trim().equals(req.getName().toLowerCase().trim())
				|| (!dao.isUsersExists(req.getName()))) {

			user.setName(req.getName());
			user.setEmail(req.getEmail());
			user.setAlternativeEmail(req.getAlternativeEmail());
			user.setPassword(req.getPassword());
			user.setPhoneNo(req.getPhoneNo());
			user.setDob(req.getDob());
			user.setBirthPlace(req.getBirthPlace());
			user.setBirthTime(req.getBirthTime());

			

			Raasi raasi = new Raasi();
			raasi.setId(req.getRaasi());
			user.setRassi(raasi);
			
			Nakshatram nakshatram = new Nakshatram();
			nakshatram.setId(req.getNakshatram());
			user.setNakshatram(nakshatram);
			
			Roles role = new Roles();
			role.setId(req.getRole());
			user.setRole(role);
			
			Gender gender = new Gender();
			gender.setId(req.getGender());
			user.setGender(gender);
			
			Status status = new Status();
			status.setId(req.getStatus());
			user.setStatus(status);

			dao.update(user);
			logger.info("user updated successfully : " + user.getId());
			return true;

		} else {
			logger.info("user already exist : " + user.getId());
			return false;

		}

	}

	/**
	 * This method returns all the user
	 */

	public List<UsersRes> getUsers() {
		List<Users> user = dao.getUsers();

		List<UsersRes> userList = new ArrayList<>();
		UsersRes userRes = null;

		for (Users users : user) {
			userRes = new UsersRes();
			userRes.setId(users.getId());
			userRes.setName(users.getName());
			userRes.setEmail(users.getEmail());
			userRes.setAlternativeEmail(users.getAlternativeEmail());
			userRes.setPassword(users.getPassword());
			userRes.setPhoneNo(users.getPhoneNo());
			userRes.setDob(users.getDob());
			userRes.setBirthPlace(users.getBirthPlace());
			userRes.setBirthTime(users.getBirthTime());
			
			userRes.setRaasi(users.getRassi().getId());
			userRes.setNakshatram(users.getNakshatram().getId());
			userRes.setRole(users.getRole().getId());
			userRes.setGender(users.getGender().getId());
			userRes.setStatus(users.getStatus().getId());
			
			userList.add(userRes);
		}

		return userList;
	}

	/**
	 * This method returns user Details for the given user id
	 */
	
	
	public UsersRes getUsers(String id) {

		Users user = (Users) dao.getByKey(Users.class, id);

		UsersRes userRes = new UsersRes();
		userRes.setId(user.getId());
		userRes.setName(user.getName());
		userRes.setEmail(user.getEmail());
		userRes.setAlternativeEmail(user.getAlternativeEmail());
		userRes.setPassword(user.getPassword());
		userRes.setPhoneNo(user.getPhoneNo());
		userRes.setDob(user.getDob());
		userRes.setBirthPlace(user.getBirthPlace());
		userRes.setBirthTime(user.getBirthTime());
		
		userRes.setRaasi(user.getRassi().getId());
		userRes.setNakshatram(user.getNakshatram().getId());
		userRes.setRole(user.getRole().getId());
		userRes.setGender(user.getGender().getId());
		userRes.setStatus(user.getStatus().getId());
		
		return userRes;
	}

	/**
	 * This method deletes the given user
	 */
	public Boolean deleteUsers(String userId) {
		return (dao.delete(Users.class, userId) != 0);
	}

	
	
}
