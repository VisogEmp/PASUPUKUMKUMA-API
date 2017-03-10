package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.AddressDao;
import com.visog.pasupukumkuma.model.transactional.Address;

@Singleton
@Transactional
public class AddressDaoImpl extends AbstractDao implements AddressDao {
	
	private static final Logger logger = Logger.getLogger(AddressDaoImpl.class);

	/**
	 * This method returns the Address data
	 */
	public List<Address> getAddress() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Address> q = cb.createQuery(Address.class);
		Root<Address> c = q.from(Address.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}

}
