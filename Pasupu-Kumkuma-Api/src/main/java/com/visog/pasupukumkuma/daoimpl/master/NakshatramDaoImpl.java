package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.NakshatramDao;
import com.visog.pasupukumkuma.model.master.Nakshatram;




@Singleton
@Transactional
public class NakshatramDaoImpl extends AbstractDao implements NakshatramDao {

	private static final Logger logger = Logger.getLogger(NakshatramDaoImpl.class);

	/**
	 * This method returns the Roles data
	 */
	public List<Nakshatram> getNakshatram() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Nakshatram> q = cb.createQuery(Nakshatram.class);
		Root<Nakshatram> c = q.from(Nakshatram.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}

	
	
	

}
