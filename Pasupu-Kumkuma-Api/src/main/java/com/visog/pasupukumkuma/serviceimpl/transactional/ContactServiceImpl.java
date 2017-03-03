package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.ContactDao;
import com.visog.pasupukumkuma.model.transactional.Contact;
import com.visog.pasupukumkuma.req.transactional.ContactReq;
import com.visog.pasupukumkuma.res.transactional.ContactRes;
import com.visog.pasupukumkuma.service.transactional.ContactService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class ContactServiceImpl implements ContactService {
	
private static final Logger logger = Logger.getLogger(ContactServiceImpl.class);
	
	@Inject
	private ContactDao dao;
	
	
	public void saveContact(ContactReq req) {

		Contact contact =new Contact();
		
		contact.setName(req.getName());
		contact.setEmail(req.getEmail());
		
		DaoUtils.setEntityCreateAuditColumns(contact);

		dao.save(contact);
		
		logger.info("Contact is created Successfully"+contact.getId());
	}

	public void updateCountry(ContactReq req, String contactid) {
		
		Contact contact =(Contact) dao.getByKey(Contact.class, contactid);
		
		contact.setEmail(req.getEmail());
		contact.setName(req.getName());
		dao.update(contact);
		
		logger.info("Contact updated succesfully"+contact.getId());
		

	}

	public List<ContactRes> getContacts() {
		
		List<Contact> contact = dao.getContacts();

		List<ContactRes> contactList = new ArrayList<>();
		ContactRes contactRes = null;

		for (Contact contacts : contact) {
			
			contactRes = new ContactRes();
			
			//contactRes.setId(contacts.getId());
			contactRes.setEmail(contacts.getEmail());
			contactRes.setName(contacts.getName());
			contactList.add(contactRes);
		}
		return contactList;
	}

	public ContactRes getContact(String id) {
		
		Contact contact =(Contact) dao.getByKey(Contact.class, id);
		ContactRes contactRes= new ContactRes();
		//contactRes.setId(contact.getId());
		contactRes.setEmail(contact.getEmail());
		contactRes.setName(contact.getName());
		return contactRes;
	}

	public Boolean deleteContact(String contactId) {
		return (dao.delete(Contact.class,contactId)!=0);
	}

	@Override
	public Boolean updateContact(ContactReq req, String contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactRes getContacts(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteContacts(String contactId) {
		// TODO Auto-generated method stub
		return null;
	}


}
