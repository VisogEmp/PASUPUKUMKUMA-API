package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.GenderDao;
import com.visog.pasupukumkuma.model.master.Gender;
@Singleton
@Transactional
public class GenderDaoImpl extends AbstractDao implements GenderDao {

	private static final Logger logger = Logger.getLogger(GenderDaoImpl.class);

	public List<Gender> getGenders() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Gender> q = cb.createQuery(Gender.class);
		Root<Gender> c = q.from(Gender.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
	}

	public Boolean isGenderExists(String name) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Gender> c = q.from(Gender.class);
		q.where(cb.equal(cb.lower(c.get("name")), name.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);

	}
	

	

}
