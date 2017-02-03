package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.RaasiReq;
import com.visog.pasupukumkuma.res.RaasiRes;


public interface RaasiService {
	
	public void saveRaasi(RaasiReq req);
	
	public void updateRaasi(RaasiReq req, String raasiId);
	
	public List<RaasiRes> getRaasi();
	
	public RaasiRes getRaasi(String id);
	
	public Boolean deleteRaasi(String raasiId);
	
}
