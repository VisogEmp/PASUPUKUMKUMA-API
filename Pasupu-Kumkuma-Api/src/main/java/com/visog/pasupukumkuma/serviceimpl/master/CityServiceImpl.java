package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;


import com.visog.pasupukumkuma.dao.master.CityDao;
import com.visog.pasupukumkuma.model.master.City;
import com.visog.pasupukumkuma.model.master.State;
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
		cites.setCountry(req.getCountry());

		City city = new City();
		city.setId(req.getState());
		
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

			State state = new State();
			state.setId(req.getState());

			cites.setState(state);

			dao.update(cites);
			logger.info("state updated successfully : " + cites.getId());
			return true;

		} else {
			logger.info("states already exist : " + cites.getId());
			return false;

		}

	}

	/**
	 * This method returns all the states
	 */

	public List<CityRes> getCity() {
		List<City> cites = dao.getCity();

		List<CityRes> stateList = new ArrayList<>();
		CityRes cityRes = null;

		for (City city : cites) {
			cityRes = new CityRes();
			cityRes.setId(city.getId());
			cityRes.setName(city.getName());
			cityRes.setState(city.getState().getId());
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
		cityRes.setState(states.getState().getId());
		return cityRes;
	}

	/**
	 * This method deletes the given role
	 */
	public Boolean deleteCity(String stateId) {
		return (dao.delete(City.class, stateId) != 0);
	}

	


}
