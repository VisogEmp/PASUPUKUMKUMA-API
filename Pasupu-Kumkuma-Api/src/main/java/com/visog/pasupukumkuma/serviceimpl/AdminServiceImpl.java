package com.visog.pasupukumkuma.serviceimpl;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AdminDao;
import com.visog.pasupukumkuma.service.AdminService;


@Singleton
public class AdminServiceImpl implements AdminService {

	private static final Logger logger = Logger.getLogger(AdminServiceImpl.class);

	@Inject
	AdminDao dao;

}
