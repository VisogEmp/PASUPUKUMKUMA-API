package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.UserRequestDao;
import com.visog.pasupukumkuma.model.transactional.UserRequest;

@Singleton
@Transactional
public class UserRequestDaoImpl extends AbstractDao implements UserRequestDao {

	public List<UserRequest> getUserRequests() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserRequest> q = cb.createQuery(UserRequest.class);
		Root<UserRequest> c = q.from(UserRequest.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

	
}
