package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.CountryDao;
import com.visog.pasupukumkuma.model.master.Country;
import com.visog.pasupukumkuma.req.CountryReq;
import com.visog.pasupukumkuma.res.CountryRes;
import com.visog.pasupukumkuma.service.master.CountryService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class CountryServiceImpl implements CountryService {

	private static final Logger logger = Logger.getLogger(CountryServiceImpl.class);
	
	@Inject
	private CountryDao dao;
	
	
	public void saveCountry(CountryReq req) {

		Country country =new Country();
		
		country.setName(req.getName());
		country.setCode(req.getCode());
		
		DaoUtils.setEntityCreateAuditColumns(country);

		dao.save(country);
		
		logger.info("Country is created Successfully"+country.getId());
	}

	public void updateCountry(CountryReq req, String countryId) {
		
		Country country =(Country) dao.getByKey(Country.class, countryId);
		
		country.setCode(req.getCode());
		country.setName(req.getName());
		dao.update(country);
		
		logger.info("Country updated succesfully"+country.getId());
		

	}

	public List<CountryRes> getCountries() {
		
		List<Country> country = dao.getCountries();

		List<CountryRes> countryList = new ArrayList<>();
		CountryRes countryRes = null;

		for (Country countries : country) {
			
			countryRes = new CountryRes();
			
			countryRes.setId(countries.getId());
			countryRes.setCode(countries.getCode());
			countryRes.setName(countries.getName());
			countryList.add(countryRes);
		}
		return countryList;
	}

	public CountryRes getCountry(String id) {
		
		Country country =(Country) dao.getByKey(Country.class, id);
		CountryRes countryRes= new CountryRes();
		countryRes.setId(country.getId());
		countryRes.setCode(country.getCode());
		countryRes.setName(country.getName());
		return countryRes;
	}

	public Boolean deleteCountry(String countryId) {
		return (dao.delete(Country.class,countryId)!=0);
	}

}
