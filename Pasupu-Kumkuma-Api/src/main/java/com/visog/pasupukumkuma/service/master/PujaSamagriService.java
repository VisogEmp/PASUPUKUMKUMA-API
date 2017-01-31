package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.PujaSamagriReq;
import com.visog.pasupukumkuma.req.RolesReq;
import com.visog.pasupukumkuma.res.PujaSamagriRes;
import com.visog.pasupukumkuma.res.RolesRes;

public interface PujaSamagriService {

	public void savePujaSamagri(PujaSamagriReq req);
	
	public void updatePujaSamagri(PujaSamagriReq req, String pujasamagriId);
	
    public List<PujaSamagriRes> getPujaSamagri();
	
	public PujaSamagriRes getPujaSamagri(String id);
	
	public Boolean deletePujaSamagri(String pujasamagriId);
}
