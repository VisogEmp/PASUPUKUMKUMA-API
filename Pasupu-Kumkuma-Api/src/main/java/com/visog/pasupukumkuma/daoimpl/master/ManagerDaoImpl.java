package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.Managerdao;
import com.visog.pasupukumkuma.model.master.Manager;

@Singleton
@Transactional
public class ManagerDaoImpl extends AbstractDao implements Managerdao {

	private static final Logger logger = Logger.getLogger(ManagerDaoImpl.class);
	
	
	public List<Manager> getManagers() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Manager> q = cb.createQuery(Manager.class);
		Root<Manager> c = q.from(Manager.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	
	

}
