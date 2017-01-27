package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.GenderReq;
import com.visog.pasupukumkuma.res.GenderRes;


public interface GenderService {

	public void saveGender(GenderReq req);

	public void updateGender(GenderReq req, String genderId);

	public List<GenderRes> getGenders();

	public GenderRes getGender(String id);
}
