package com.visog.pasupukumkuma.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.AbstractDao;
import com.visog.pasupukumkuma.dao.master.StateDao;
import com.visog.pasupukumkuma.model.master.State;
import com.visog.pasupukumkuma.model.master.Users;


@Singleton
@Transactional
public class UsersDaoImpl extends AbstractDao implements StateDao {
	
	private static final Logger logger = Logger.getLogger(UsersDaoImpl.class);

	public List<State> getState() {
		return null;
	}

	public Boolean isStateExists(String name) {
		return null;
	}

	
	
}
