package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.RoleDao;
import com.visog.pasupukumkuma.model.master.Roles;




@Singleton
@Transactional
public class RolesDaoImpl extends AbstractDao implements RoleDao {

	private static final Logger logger = Logger.getLogger(RolesDaoImpl.class);

	/**
	 * This method returns the Roles data
	 */
	public List<Roles> getRoles() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Roles> q = cb.createQuery(Roles.class);
		Root<Roles> c = q.from(Roles.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}

	
	
	

}
