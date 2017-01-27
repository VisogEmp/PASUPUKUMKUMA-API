package com.visog.pasupukumkuma.daoimpl;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.SuperAdminDao;


@Singleton
@Transactional
public class SuperAdminDaoImpl implements SuperAdminDao {

	@PersistenceContext(unitName = "PasupuKumkumaApi")
	private EntityManager em;

	private static final Logger logger = Logger.getLogger(SuperAdminDaoImpl.class);

}
