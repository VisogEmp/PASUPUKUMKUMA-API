package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.PujaOrderDao;
import com.visog.pasupukumkuma.model.transactional.PujaOrder;


@Singleton
@Transactional
public class PujaOrderDaoImpl extends AbstractDao implements PujaOrderDao{
	
	private static final Logger logger = Logger.getLogger(PujaOrderDaoImpl.class);
	
	public List<PujaOrder> getPujaOrder() {
	
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<PujaOrder> q = cb.createQuery(PujaOrder.class);
	Root<PujaOrder> c = q.from(PujaOrder.class);
	q.select(c);
	return em.createQuery(q).getResultList();
	
	}

}
