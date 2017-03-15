package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.PujaOrderReq;
import com.visog.pasupukumkuma.res.transactional.PujaOrderRes;



public interface PujaOrderService {
	
	public void savePujaOrder(PujaOrderReq req);
	
	public Boolean updatePujaOrder(PujaOrderReq req, String pujaOrderId);
	
	public List<PujaOrderRes> getPujaOrder();
	
	public PujaOrderRes getPujaOrder(String id);
	
	public Boolean deletePujaOrder(String pujaOrderId);

}
