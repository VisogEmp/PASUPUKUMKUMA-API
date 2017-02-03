package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.PujaSamagriDao;
import com.visog.pasupukumkuma.model.master.Puja;
import com.visog.pasupukumkuma.model.master.PujaSamagri;
import com.visog.pasupukumkuma.model.master.State;

@Singleton
@Transactional
public class PujaSamagriDaoImpl extends AbstractDao implements PujaSamagriDao {

	private static final Logger logger = Logger.getLogger(PujaSamagriDaoImpl.class);

	/**
	 * This method returns the PujaSamagri data
	 */
	
	public List<PujaSamagri> getPujaSamagri() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PujaSamagri> q = cb.createQuery(PujaSamagri.class);
		Root<PujaSamagri> c = q.from(PujaSamagri.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
	}

	
	public Boolean isPujaSamagriExists(String name) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<PujaSamagri> c = q.from(PujaSamagri.class);
		q.where(cb.equal(cb.lower(c.get("name")), name.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);

	}
	
	

}
