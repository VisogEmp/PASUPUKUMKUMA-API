package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.NakshatramReq;
import com.visog.pasupukumkuma.res.NakshatramRes;



public interface NakshatramService {
	
	public void saveNakshatram(NakshatramReq req);
	
	public void updateNakshatram(NakshatramReq req, String nakshatramId);
	
	public List<NakshatramRes> getNakshatram();
	
	public NakshatramRes getNakshatram(String id);
	
	public Boolean deleteNakshatram(String nakshatramId);
	
}
