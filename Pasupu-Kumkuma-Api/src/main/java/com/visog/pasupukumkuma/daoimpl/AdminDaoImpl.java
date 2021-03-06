package com.visog.pasupukumkuma.daoimpl;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AdminDao;


@Singleton
@Transactional
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext(unitName = "PasupuKumkumaApi")
	private EntityManager em;

	private static final Logger logger = Logger.getLogger(AdminDaoImpl.class);

}
