package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.AddressReq;
import com.visog.pasupukumkuma.res.transactional.AddressRes;


public interface AddressService {
	
    public void saveAddress(AddressReq req);
	
	public void updateAddress(AddressReq req, String addressId);
	
	public List<AddressRes> getAddress();
	
	public AddressRes getAddress(String id);
	
	public Boolean deleteAddress(String addressId);

}
