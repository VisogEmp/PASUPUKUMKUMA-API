package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.PujaOrderDetailsDao;
import com.visog.pasupukumkuma.model.transactional.PujaOrderDetails;


@Singleton
@Transactional
public class PujaOrderDetailsDaoImpl extends AbstractDao implements PujaOrderDetailsDao  {
	
	private static final Logger logger = Logger.getLogger(PujaOrderDetailsDaoImpl.class);

	public List<PujaOrderDetails> getPujaOrderDetails() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PujaOrderDetails> q = cb.createQuery(PujaOrderDetails.class);
		Root<PujaOrderDetails> c = q.from(PujaOrderDetails.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

}
