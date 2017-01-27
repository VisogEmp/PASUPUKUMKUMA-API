package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.CountryReq;
import com.visog.pasupukumkuma.res.CountryRes;


public interface CountryService {

	
public void saveCountry(CountryReq req);
	
	public void updateCountry(CountryReq req, String countryId);
	
	public List<CountryRes> getCountries();
	
	public CountryRes getCountry(String id);
	
	public Boolean deleteCountry(String countryId);
}
