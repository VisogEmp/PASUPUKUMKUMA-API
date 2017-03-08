package com.visog.pasupukumkuma.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transaction.UsersDao;
import com.visog.pasupukumkuma.model.transaction.Users;

@Singleton
@Transactional
public class UsersDaoImpl extends AbstractDao implements UsersDao {

	private static final Logger logger = Logger.getLogger(UsersDaoImpl.class);

	public List<Users> getUsers() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Users> q = cb.createQuery(Users.class);
		Root<Users> c = q.from(Users.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

}
