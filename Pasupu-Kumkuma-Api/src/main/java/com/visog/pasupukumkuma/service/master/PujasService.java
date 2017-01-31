package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.PujaReq;
import com.visog.pasupukumkuma.res.PujaRes;



public interface PujasService {

   public void savePujas(PujaReq req);
	
	public void updatePujas(PujaReq req, String pujasId);
	
	public List<PujaRes> getPujas();
	
	public PujaRes getPujas(String id);
	
	public Boolean deletePujas(String pujasId);
	
	
}
