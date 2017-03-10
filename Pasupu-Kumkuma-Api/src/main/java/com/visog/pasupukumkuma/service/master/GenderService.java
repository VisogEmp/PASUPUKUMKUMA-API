package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.GenderReq;
import com.visog.pasupukumkuma.req.PujaReq;
import com.visog.pasupukumkuma.req.RolesReq;
import com.visog.pasupukumkuma.res.GenderRes;
import com.visog.pasupukumkuma.res.PujaRes;
import com.visog.pasupukumkuma.res.RolesRes;


public interface GenderService {

    public void saveGender(GenderReq req);
	
	public void updateGender(GenderReq req, String genderId);
	
	public List<GenderRes> getGender();
	
	public GenderRes getGender(String id);
	
	public Boolean deleteGender(String genderId);
}
