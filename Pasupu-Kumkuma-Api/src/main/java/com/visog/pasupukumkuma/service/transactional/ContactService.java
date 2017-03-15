package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.ContactReq;
import com.visog.pasupukumkuma.res.transactional.ContactRes;


public interface ContactService {
	
	public void saveContact(ContactReq req);
	
	public void updateContact(ContactReq req, String contactId);
	
	public List<ContactRes> getContacts();
	
	public ContactRes getContact(String id);
	
	public Boolean deleteContact(String contactId);


}
