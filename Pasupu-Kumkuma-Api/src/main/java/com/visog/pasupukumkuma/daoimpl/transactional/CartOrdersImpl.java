package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.CartOrdersDao;
import com.visog.pasupukumkuma.model.transactional.CartOrders;

@Singleton
@Transactional
public class CartOrdersImpl extends AbstractDao implements CartOrdersDao{
	
	private static final Logger logger = Logger.getLogger(CartOrdersImpl.class);
	
		public List<CartOrders> getCartOrders() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CartOrders> q = cb.createQuery(CartOrders.class);
		Root<CartOrders> c = q.from(CartOrders.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		}
}
