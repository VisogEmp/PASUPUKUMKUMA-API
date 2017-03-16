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

	public void saveUser(UsersReq req) {

		Users users = new Users();
		
		Roles roles = new Roles();
		roles.setId(req.getRole());
		users.setRole(roles);

		Gender gender = new Gender();
		gender.setId(req.getGender());
		users.setGender(gender);

		users.setName(req.getName());
		users.setEmail(req.getEmail());
		users.setAlternativeEmail(req.getAlternativeEmail());
		users.setPassword(req.getPassword());
		users.setPhoneNo(req.getPhoneNo());
		users.setDob(req.getDob());
		users.setBirthPlace(req.getBirthPlace());
		users.setBirthTime(req.getBirthTime());

		Raasi raasi = new Raasi();
		raasi.setId(req.getRaasi());
		users.setRaasi(raasi);
		Nakshatram nakshatram = new Nakshatram();
		nakshatram.setId(req.getNakshatram());
		users.setNakshatram(nakshatram);
		Status status = new Status();
		status.setId(req.getStatus());
		users.setStatus(status);

		DaoUtils.setEntityCreateAuditColumns(users);
		
		dao.save(users);

		logger.info("Users created successfully : " + users.getId());

	}

	public void updateUser(UsersReq req, String usersId) {

		Users users = (Users) dao.getByKey(Users.class, usersId);

		Roles roles = new Roles();
		roles.setId(req.getRole());
		users.setRole(roles);

		Gender gender = new Gender();
		gender.setId(req.getGender());
		users.setGender(gender);

		users.setName(req.getName());
		users.setEmail(req.getEmail());
		users.setAlternativeEmail(req.getAlternativeEmail());
		users.setPassword(req.getPassword());
		users.setPhoneNo(req.getPhoneNo());
		users.setDob(req.getDob());
		users.setBirthPlace(req.getBirthPlace());
		users.setBirthTime(req.getBirthTime());

		Raasi raasi = new Raasi();
		raasi.setId(req.getRaasi());
		users.setRaasi(raasi);
		Nakshatram nakshatram = new Nakshatram();
		nakshatram.setId(req.getNakshatram());
		users.setNakshatram(nakshatram);
		Status status = new Status();
		status.setId(req.getStatus());
		users.setStatus(status);
		dao.update(users);

		logger.info("Users updated successfully : " + users.getId());

	}

	public List<UsersRes> getUsers() {

		List<Users> users = dao.getUsers();
		List<UsersRes> usersList = new ArrayList<>();
		UsersRes usersRes = null;
		for (Users user : users) {
			usersRes = new UsersRes();
			usersRes.setId(user.getId());
			usersRes.setRole(user.getRole().getId());
			usersRes.setGender(user.getGender().getId());
			usersRes.setName(user.getName());
			usersRes.setEmail(user.getEmail());
			usersRes.setAlternativeEmail(user.getAlternativeEmail());
			usersRes.setPassword(user.getPassword());
			usersRes.setPhoneNo(user.getPassword());
			usersRes.setDob(user.getDob());
			usersRes.setBirthPlace(user.getBirthPlace());
			usersRes.setBirthTime(user.getBirthTime());
			usersRes.setRaasi(user.getRaasi().getId());
			usersRes.setNakshatram(user.getNakshatram().getId());
			usersRes.setStatus(user.getStatus().getId());
			usersList.add(usersRes);

		}
		return usersList;
	}

	public UsersRes getUser(String id) {
		Users user = (Users) dao.getByKey(Users.class, id);
		UsersRes usersRes = new UsersRes();
		
		usersRes.setId(user.getId());
		usersRes.setRole(user.getRole().getId());
		usersRes.setGender(user.getGender().getId());
		usersRes.setName(user.getName());
		usersRes.setEmail(user.getEmail());
		usersRes.setAlternativeEmail(user.getAlternativeEmail());
		usersRes.setPassword(user.getPassword());
		usersRes.setPhoneNo(user.getPassword());
		usersRes.setDob(user.getDob());
		usersRes.setBirthPlace(user.getBirthPlace());
		usersRes.setBirthTime(user.getBirthTime());
		usersRes.setRaasi(user.getRaasi().getId());
		usersRes.setNakshatram(user.getNakshatram().getId());
		usersRes.setStatus(user.getStatus().getId());
		
		return usersRes;
	}

	public Boolean deleteUser(String usersId) {
		return (dao.delete(Users.class, usersId) !=0);
	}

}
