package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.PujaSamagriReq;
import com.visog.pasupukumkuma.req.RolesReq;
import com.visog.pasupukumkuma.req.StateReq;
import com.visog.pasupukumkuma.res.PujaSamagriRes;
import com.visog.pasupukumkuma.res.RolesRes;
import com.visog.pasupukumkuma.res.StateRes;

public interface PujaSamagriService {


	public Boolean savePujaSamagri(PujaSamagriReq req);
	
	public Boolean updatePujaSamagri(PujaSamagriReq req, String pujasamagriId);
	
	public List<PujaSamagriRes> getPujaSamagri();
	
	public PujaSamagriRes getPujaSamagri(String id);
	
	public Boolean deletePujaSamagri(String pujasamagriId);
}
