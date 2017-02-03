package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.CityReq;
import com.visog.pasupukumkuma.res.CityRes;



public interface CityService {

public Boolean saveCity(CityReq req);
	
	public Boolean updateCity(CityReq req, String cityId);
	
	public List<CityRes> getCity();
	
	public CityRes getCity(String id);
	
	public Boolean deleteCity(String stateId);

}
