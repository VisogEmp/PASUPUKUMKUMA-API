package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.CouponDetailsDao;
import com.visog.pasupukumkuma.model.transactional.CouponDetails;

@Singleton
@Transactional
public class CouponDetailsDaoImpl extends AbstractDao implements CouponDetailsDao {

	private static final Logger logger = Logger.getLogger(CouponDetailsDaoImpl.class);

	public List<CouponDetails> getCouponDetails() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CouponDetails> q = cb.createQuery(CouponDetails.class);
		Root<CouponDetails> c = q.from(CouponDetails.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

}
