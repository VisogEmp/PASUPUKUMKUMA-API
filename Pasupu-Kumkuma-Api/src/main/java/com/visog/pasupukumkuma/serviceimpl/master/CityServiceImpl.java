package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;


import com.visog.pasupukumkuma.dao.master.CityDao;
import com.visog.pasupukumkuma.model.master.City;
import com.visog.pasupukumkuma.model.master.Country;
import com.visog.pasupukumkuma.req.CityReq;
import com.visog.pasupukumkuma.res.CityRes;
import com.visog.pasupukumkuma.service.master.CityService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class CityServiceImpl implements CityService {
	
private static final Logger logger = Logger.getLogger(CityServiceImpl.class);
	
	@Inject
	private CityDao dao;
	
	
	public Boolean saveCity(CityReq req) {

		City cites = new City();
		cites.setName(req.getName());

		Country country = new Country();
		country.setId(req.getCountry());
		cites.setCity(country);
		DaoUtils.setEntityCreateAuditColumns(cites);

		if (dao.isCityExists(req.getName())) {

			logger.info("State already exist : " + cites.getId());
			return false;

		} else {
			dao.save(cites);

			logger.info("state created successfully : " + cites.getId());
			return true;

		}

	}

	/**
	 * This method updates the State
	 */
	public Boolean updateCity(CityReq req, String stateId) {

		City cites = (City) dao.getByKey(City.class, stateId);
		logger.info("City exist : " + cites.getName().toLowerCase().trim());
		logger.info("cites new : " + req.getName().toLowerCase().trim());

		if (cites.getName().toLowerCase().trim().equals(req.getName().toLowerCase().trim())
				|| (!dao.isCityExists(req.getName()))) {

			cites.setName(req.getName());

			Country country = new Country();
			country.setId(req.getCountry());

			cites.setCountry(country);

			dao.update(cites);
			logger.info("state updated successfully : " + cites.getId());
			return true;

		} else {
			logger.info("states already exist : " + states.getId());
			return false;

		}

	}

	/**
	 * This method returns all the states
	 */

	public List<CityRes> getCity() {
		List<City> states = dao.getCity();

		List<CityRes> stateList = new ArrayList<>();
		CityRes cityRes = null;

		for (City state : states) {
			cityRes = new CityRes();
			cityRes.setId(state.getId());
			cityRes.setName(state.getName());
			cityRes.setCountry(state.getCountry().getId());
			stateList.add(cityRes);
		}

		return stateList;
	}

	/**
	 * This method returns State Details for the given state id
	 */

	public CityRes getCity(String id) {

		City states = (City) dao.getByKey(City.class, id);

		CityRes cityRes = new CityRes();
		cityRes.setId(states.getId());
		cityRes.setName(states.getName());
		cityRes.setCountry(states.getCountry().getId());
		return cityRes;
	}

	/**
	 * This method deletes the given role
	 */
	public Boolean deleteCity(String stateId) {
		return (dao.delete(City.class, stateId) != 0);
	}

	


}
