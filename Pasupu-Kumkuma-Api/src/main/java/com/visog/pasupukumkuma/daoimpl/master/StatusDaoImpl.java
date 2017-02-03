package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.StatusDao;
import com.visog.pasupukumkuma.model.master.Status;

@Singleton
@Transactional
public class StatusDaoImpl extends AbstractDao implements StatusDao {
	
	private static final Logger logger = Logger.getLogger(StatusDaoImpl.class);


	public List<Status> getStatus() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Status> q = cb.createQuery(Status.class);
		Root<Status> c = q.from(Status.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

}
