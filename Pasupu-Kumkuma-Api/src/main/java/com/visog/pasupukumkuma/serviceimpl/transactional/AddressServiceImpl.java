package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.AddressDao;
import com.visog.pasupukumkuma.model.master.City;
import com.visog.pasupukumkuma.model.master.Country;
import com.visog.pasupukumkuma.model.master.State;
import com.visog.pasupukumkuma.model.transactional.Address;
import com.visog.pasupukumkuma.model.transactional.Users;
import com.visog.pasupukumkuma.req.transactional.AddressReq;
import com.visog.pasupukumkuma.res.transactional.AddressRes;
import com.visog.pasupukumkuma.service.transactional.AddressService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class AddressServiceImpl implements AddressService{
	
	private static final Logger logger = Logger.getLogger(AddressServiceImpl.class);

	@Inject
	AddressDao dao;

	/**
	 * This method saves the Address
	 */

	public void saveAddress(AddressReq req) {
		
		Address address=new Address();
		address.setAddressLine1(req.getAddressLine1());
		address.setAddressLine2(req.getAddressLine2());
		address.setZipcode(req.getZipcode());
		
		Country country = new Country();
		country.setId(req.getCountry());
		address.setCountry(country);
		
		State state = new State();
		state.setId(req.getState());
		address.setState(state);
		
		Users user = new Users();
		user.setId(req.getUser());
		address.setUser(user);
		
		City city = new City();
		city.setId(req.getCity());
		address.setCity(city);
		
		DaoUtils.setEntityCreateAuditColumns(address);
		
         dao.save(address);
         
         logger.info("Address created successfully : " + address.getId());
         
	}
	
	/**
	 * This method updates the Address
	 */

	public void updateAddress(AddressReq req, String addressId) {
		
	
		Address address = (Address) dao.getByKey(Address.class, addressId);
		address.setAddressLine1(req.getAddressLine1());
		address.setAddressLine2(req.getAddressLine2());
		address.setZipcode(req.getZipcode());
		
		Country country = new Country();
		country.setId(req.getCountry());
		address.setCountry(country);
		
		City city = new City();
		city.setId(req.getCity());
		address.setCity(city);
		
		State state = new State();
		state.setId(req.getState());
		address.setState(state);
		
		Users user = new Users();
		user.setId(req.getUser());
		address.setUser(user);
		
		
		dao.update(address);
		logger.info("Address updated successfully : " + address.getId());
	}

	/**
	 * This method returns all the Address
	 */

	public List<AddressRes> getAddress() {
		
		List<Address> addresess = dao.getAddress();

		List<AddressRes> addressList = new ArrayList<>();
		AddressRes addressRes = null;

		for (Address address : addresess) {
			addressRes = new AddressRes();
			addressRes.setId( address.getId());
			addressRes.setAddressLine1(address.getAddressLine1());
			addressRes.setAddressLine2(address.getAddressLine2());
			addressRes.setZipcode(address.getZipcode());
			
			addressRes.setCountry(address.getCountry().getId());
			addressRes.setCity(address.getCity().getId());
			addressRes.setState(address.getState().getId());
			addressRes.setUser(address.getUser().getId());
			
			
			
			addressList.add(addressRes);
		}

		return addressList;
	}
	/**
	 * This method returns Address Details for the given address id  
	 */

	public AddressRes getAddress(String id) {
      
		Address address = (Address) dao.getByKey(Address.class, id);
		AddressRes addressRes = new AddressRes();
		addressRes.setId(address.getId());
		addressRes.setAddressLine1(address.getAddressLine1());
		addressRes.setAddressLine2(address.getAddressLine2());
		addressRes.setZipcode(address.getZipcode());
		
		addressRes.setCountry(address.getCountry().getId());
		addressRes.setCity(address.getCity().getId());
		addressRes.setState(address.getState().getId());
		addressRes.setUser(address.getUser().getId());
		
		
		
		return addressRes;

		
	}
	
	/**
	 * This method deletes the given Address  
	 */

	public Boolean deleteAddress(String addressId) {
		return (dao.delete(Address.class, addressId) != 0);
	}

}
