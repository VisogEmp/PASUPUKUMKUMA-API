package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.PujaSamagriPujaReq;
import com.visog.pasupukumkuma.res.PujaSamagriPujaRes;

public interface PujaSamagriPujaService {

    public void savePujaSamagriPuja(PujaSamagriPujaReq req);
	
	public void updatePujaSamagriPuja(PujaSamagriPujaReq req, String pujasamagripujaId);
	
	public List<PujaSamagriPujaRes> getPujaSamagriPuja();
	
	public PujaSamagriPujaRes getPujaSamagriPuja(String id);
	
	public Boolean deletePujaSamagriPuja(String pujasamagripujaId);
}
