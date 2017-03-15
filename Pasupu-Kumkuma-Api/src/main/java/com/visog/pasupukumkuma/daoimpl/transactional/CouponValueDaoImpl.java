package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.CouponValueDao;
import com.visog.pasupukumkuma.model.transactional.CouponValue;

@Singleton
@Transactional
 public class CouponValueDaoImpl extends AbstractDao implements CouponValueDao {


	
	public List<CouponValue> getCouponValues() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CouponValue> q = cb.createQuery(CouponValue.class);
		Root<CouponValue> c = q.from(CouponValue.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	}