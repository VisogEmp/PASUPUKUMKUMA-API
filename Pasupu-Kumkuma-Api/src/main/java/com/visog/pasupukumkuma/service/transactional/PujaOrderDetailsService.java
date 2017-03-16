package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.PujaOrderDetailsReq;
import com.visog.pasupukumkuma.res.transactional.PujaOrderDetailsRes;

public interface PujaOrderDetailsService {
	
	public void savePujaOrderDetails(PujaOrderDetailsReq req);
	
	public void updatePujaOrderDetails(PujaOrderDetailsReq req, String pujaorderdetailsId);
	
	public List<PujaOrderDetailsRes> getPujaOrderDetails();
	
	public PujaOrderDetailsRes getPujaOrderDetails(String id);
	
	public Boolean deletePujaOrderDetails(String pujaorderdetailsId);

}
