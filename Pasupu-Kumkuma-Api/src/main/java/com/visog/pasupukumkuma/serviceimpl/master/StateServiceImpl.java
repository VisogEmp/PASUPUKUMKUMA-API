package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;


import com.visog.pasupukumkuma.dao.master.StateDao;
import com.visog.pasupukumkuma.model.master.Country;
import com.visog.pasupukumkuma.model.master.State;
import com.visog.pasupukumkuma.req.StateReq;
import com.visog.pasupukumkuma.res.StateRes;
import com.visog.pasupukumkuma.service.master.StateService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class StateServiceImpl implements StateService {

private static final Logger logger = Logger.getLogger(StateServiceImpl.class);
	
	@Inject
	private StateDao dao;
	
	
	public Boolean saveState(StateReq req) {

		State states = new State();
		states.setName(req.getName());

		Country country = new Country();
		country.setId(req.getCountry());
		states.setCountry(country);
		DaoUtils.setEntityCreateAuditColumns(states);

		if (dao.isStateExists(req.getName())) {

			logger.info("State already exist : " + states.getId());
			return false;

		} else {
			dao.save(states);

			logger.info("state created successfully : " + states.getId());
			return true;

		}

	}

	/**
	 * This method updates the State
	 */
	public Boolean updateState(StateReq req, String stateId) {

		State states = (State) dao.getByKey(State.class, stateId);
		logger.info("states exist : " + states.getName().toLowerCase().trim());
		logger.info("states new : " + req.getName().toLowerCase().trim());

		if (states.getName().toLowerCase().trim().equals(req.getName().toLowerCase().trim())
				|| (!dao.isStateExists(req.getName()))) {

			states.setName(req.getName());

			Country country = new Country();
			country.setId(req.getCountry());

			states.setCountry(country);

			dao.update(states);
			logger.info("state updated successfully : " + states.getId());
			return true;

		} else {
			logger.info("states already exist : " + states.getId());
			return false;

		}

	}

	/**
	 * This method returns all the states
	 */

	public List<StateRes> getState() {
		List<State> states = dao.getState();

		List<StateRes> stateList = new ArrayList<>();
		StateRes stateRes = null;

		for (State state : states) {
			stateRes = new StateRes();
			stateRes.setId(state.getId());
			stateRes.setName(state.getName());
			stateRes.setCountry(state.getCountry().getId());
			stateList.add(stateRes);
		}

		return stateList;
	}

	/**
	 * This method returns State Details for the given state id
	 */

	public StateRes getState(String id) {

		State states = (State) dao.getByKey(State.class, id);

		StateRes stateRes = new StateRes();
		stateRes.setId(states.getId());
		stateRes.setName(states.getName());
		stateRes.setCountry(states.getCountry().getId());
		return stateRes;
	}

	/**
	 * This method deletes the given role
	 */
	public Boolean deleteState(String stateId) {
		return (dao.delete(State.class, stateId) != 0);
	}

	

}

