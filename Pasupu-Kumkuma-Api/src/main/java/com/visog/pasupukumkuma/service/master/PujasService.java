package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.PujasReq;
import com.visog.pasupukumkuma.res.PujasRes;



public interface PujasService {

   public void savePujas(PujasReq req);
	
	public void updatePujas(PujasReq req, String pujasId);
	
	public List<PujasRes> getPujas();
	
	public PujasRes getPujas(String id);
	
	public Boolean deletePujas(String pujasId);
	
	
}
