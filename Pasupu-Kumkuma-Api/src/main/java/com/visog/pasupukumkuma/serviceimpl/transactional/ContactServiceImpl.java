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
		contact.setPhoneno(req.getPhoneno());
		contact.setSubject(req.getSubject());
		contact.setQuery(req.getQuery());
		contact.setDatetime(req.getDatetime());
		
		DaoUtils.setEntityCreateAuditColumns(contact);

		dao.save(contact);
		
		logger.info("Contact is created Successfully"+contact.getId());
	}

	public void updateContact(ContactReq req, String contactid) {
		
		Contact contact =(Contact) dao.getByKey(Contact.class, contactid);
		
		
		contact.setName(req.getName());
		contact.setEmail(req.getEmail());
		contact.setPhoneno(req.getPhoneno());
		contact.setSubject(req.getSubject());
		contact.setQuery(req.getQuery());
		contact.setDatetime(req.getDatetime());
		
		dao.update(contact);
		
		logger.info("Contact updated succesfully"+contact.getId());
		

	}

	public List<ContactRes> getContacts() {
		
		List<Contact> contacts = dao.getContacts();
		List<ContactRes> contactList = new ArrayList<>();
		
		ContactRes contactRes = null;

		for (Contact contact : contacts) {
			
			contactRes = new ContactRes();
			
			contactRes.setId(contact.getId());
			contactRes.setEmail(contact.getEmail());
			contactRes.setName(contact.getName());
			contactRes.setPhoneno(contact.getPhoneno());
			contactRes.setSubject(contact.getSubject());
			contactRes.setQuery(contact.getQuery());
			contactRes.setDatetime(contact.getDatetime());
			
			contactList.add(contactRes);
		}
		return contactList;
	}

	public ContactRes getContact(String id) {
		
		Contact contact =(Contact) dao.getByKey(Contact.class, id);
		
		ContactRes contactRes= new ContactRes();
		contactRes.setId(contact.getId());
		contactRes.setEmail(contact.getEmail());
		contactRes.setName(contact.getName());
		contactRes.setPhoneno(contact.getPhoneno());
		contactRes.setSubject(contact.getSubject());
		contactRes.setQuery(contact.getQuery());
		contactRes.setDatetime(contact.getDatetime());
		return contactRes;
	}

	public Boolean deleteContact(String contactId) {
		return (dao.delete(Contact.class,contactId)!=0);
	}

}
