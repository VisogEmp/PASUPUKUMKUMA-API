package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.CouponTypeDao;
import com.visog.pasupukumkuma.model.master.CouponType;
import com.visog.pasupukumkuma.model.master.PujaSamagri;

public class CouponTypeDaoImpl extends AbstractDao implements CouponTypeDao {

	private static final Logger logger = Logger.getLogger(CouponTypeDaoImpl.class);

	/**
	 * This method returns the CouponType data
	 */

	public List<CouponType> getCouponType() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CouponType> q = cb.createQuery(CouponType.class);
		Root<CouponType> c = q.from(CouponType.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

}
