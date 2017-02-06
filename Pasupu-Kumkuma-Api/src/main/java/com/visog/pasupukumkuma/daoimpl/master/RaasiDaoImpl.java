package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.RaasiDao;
import com.visog.pasupukumkuma.model.master.Raasi;




@Singleton
@Transactional
public class RaasiDaoImpl extends AbstractDao implements RaasiDao {

	private static final Logger logger = Logger.getLogger(RaasiDaoImpl.class);

	/**
	 * This method returns the Roles data
	 */
	public List<Raasi> getRaasi() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Raasi> q = cb.createQuery(Raasi.class);
		Root<Raasi> c = q.from(Raasi.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}

	
	
	

}
