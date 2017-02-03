package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.PujaReq;
import com.visog.pasupukumkuma.req.StateReq;
import com.visog.pasupukumkuma.res.PujaRes;
import com.visog.pasupukumkuma.res.StateRes;



public interface PujaService {

	 public Boolean savePuja(PujaReq req);
		
		public Boolean updatePuja(PujaReq req, String pujaId);
		
		public List<PujaRes> getPuja();
		
		public PujaRes getPuja(String id);
		
		public Boolean deletePuja(String pujaId);

}
