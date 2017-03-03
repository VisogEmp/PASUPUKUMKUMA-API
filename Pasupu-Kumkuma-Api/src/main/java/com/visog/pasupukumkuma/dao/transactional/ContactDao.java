package com.visog.pasupukumkuma.dao.transactional;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.transactional.Contact;

public interface ContactDao extends AbstractDaoI {
	
	public List<Contact> getContacts();
	
	public Boolean isUsersExists(String name);
	
	

}
