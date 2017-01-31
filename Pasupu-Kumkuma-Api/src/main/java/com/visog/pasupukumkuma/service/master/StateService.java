package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.StateReq;
import com.visog.pasupukumkuma.res.StateRes;

public interface StateService {
	
public Boolean saveState(StateReq req);
	
	public Boolean updateState(StateReq req, String stateId);
	
	public List<StateRes> getState();
	
	public StateRes getState(String id);
	
	public Boolean deleteState(String stateId);

}
