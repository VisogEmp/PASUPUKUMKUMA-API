package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.PujaDao;
import com.visog.pasupukumkuma.model.master.Puja;
import com.visog.pasupukumkuma.model.master.State;


@Singleton
@Transactional
public class PujaDaoImpl  extends AbstractDao implements PujaDao{
	
	private static final Logger logger = Logger.getLogger(PujaDaoImpl.class);

	/**
	 * This method returns the Pujas data
	 */

	public List<Puja> getPujas() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Puja> q = cb.createQuery(Puja.class);
		Root<Puja> c = q.from(Puja.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
	}

	public Boolean isPujaExists(String name) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Puja> c = q.from(Puja.class);
		q.where(cb.equal(cb.lower(c.get("name")), name.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);

	}
	
	

}
