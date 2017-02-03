package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.PujaSamagriPujaDao;
import com.visog.pasupukumkuma.model.master.PujaSamagriPuja;

@Singleton
@Transactional
public class PujaSamagriPujaDaoImpl extends AbstractDao implements PujaSamagriPujaDao {

	
	public List<PujaSamagriPuja> getPujaSamagriPuja() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PujaSamagriPuja> q = cb.createQuery(PujaSamagriPuja.class);
		Root<PujaSamagriPuja> c = q.from(PujaSamagriPuja.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	
	

	

}
