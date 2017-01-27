package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.CountryDao;
import com.visog.pasupukumkuma.model.master.Country;

@Singleton
@Transactional
public class CountryDaoImpl extends AbstractDao implements CountryDao {

	private static final Logger logger = Logger.getLogger(CountryDaoImpl.class);
	
	
	public List<Country> getCountries() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Country> q = cb.createQuery(Country.class);
		Root<Country> c = q.from(Country.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

}
