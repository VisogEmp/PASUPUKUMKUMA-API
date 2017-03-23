package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.RefferalDetailsDao;
import com.visog.pasupukumkuma.model.transactional.RefferalDetails;

@Singleton
@Transactional

public class RefferalDetailsDaoImpl extends AbstractDao implements RefferalDetailsDao  {
	
	private static final Logger logger = Logger.getLogger(RefferalDetailsDaoImpl.class);
	
	public List<RefferalDetails> getRefferalDetails() {
	
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<RefferalDetails> q = cb.createQuery(RefferalDetails.class);
	Root<RefferalDetails> c = q.from(RefferalDetails.class);
	q.select(c);
	return em.createQuery(q).getResultList();
	
	}	

}
