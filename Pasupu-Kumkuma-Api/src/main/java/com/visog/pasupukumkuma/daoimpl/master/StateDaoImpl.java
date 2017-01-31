package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.StateDao;
import com.visog.pasupukumkuma.model.master.State;

@Singleton
@Transactional
public class StateDaoImpl extends AbstractDao implements StateDao {

	private static final Logger logger = Logger.getLogger(StateDaoImpl.class);

	public List<State> getState() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<State> q = cb.createQuery(State.class);
		Root<State> c = q.from(State.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	public Boolean isStateExists(String name) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<State> c = q.from(State.class);
		q.where(cb.equal(cb.lower(c.get("name")), name.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);

	}
}
