package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.PujasDao;
import com.visog.pasupukumkuma.model.master.Pujas;


@Singleton
@Transactional
public class PujasDaoImpl  extends AbstractDao implements PujasDao{
	
	private static final Logger logger = Logger.getLogger(PujasDaoImpl.class);

	/**
	 * This method returns the Pujas data
	 */

	public List<Pujas> getPujas() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pujas> q = cb.createQuery(Pujas.class);
		Root<Pujas> c = q.from(Pujas.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
	}

}
