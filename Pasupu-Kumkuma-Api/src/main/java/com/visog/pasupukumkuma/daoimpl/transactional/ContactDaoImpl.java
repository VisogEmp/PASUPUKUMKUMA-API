package com.visog.pasupukumkuma.daoimpl.transactional;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.transactional.ContactDao;
import com.visog.pasupukumkuma.model.transactional.Contact;
import com.visog.pasupukumkuma.model.transactional.Users;


@Singleton
@Transactional
public class ContactDaoImpl extends AbstractDao implements ContactDao {
	
public List<Contact> getContacts() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contact> q = cb.createQuery(Contact.class);
		Root<Contact> c = q.from(Contact.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
	}

	public Boolean isUsersExists(String name) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Users> c = q.from(Users.class);
		q.where(cb.equal(cb.lower(c.get("name")), name.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);

	}

	
	
	

}
