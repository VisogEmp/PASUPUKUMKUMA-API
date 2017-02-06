package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.CouponDao;
import com.visog.pasupukumkuma.dao.master.RoleDao;
import com.visog.pasupukumkuma.model.master.Coupon;
import com.visog.pasupukumkuma.model.master.Roles;




@Singleton
@Transactional
public class CouponDaoImpl extends AbstractDao implements CouponDao {

	private static final Logger logger = Logger.getLogger(CouponDaoImpl.class);

	/**
	 * This method returns the Coupon data
	 * nitish
	 */
	@Override
	public List<Coupon> getCoupon() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Coupon> q = cb.createQuery(Coupon.class);
		Root<Coupon> c=q.from(Coupon.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	
	
	

}
