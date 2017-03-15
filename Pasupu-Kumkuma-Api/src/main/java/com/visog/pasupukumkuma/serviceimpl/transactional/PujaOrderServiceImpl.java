package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.PujaOrderDao;
import com.visog.pasupukumkuma.model.master.Puja;
import com.visog.pasupukumkuma.model.master.Status;
import com.visog.pasupukumkuma.model.transactional.PujaOrder;
import com.visog.pasupukumkuma.model.transactional.Users;
import com.visog.pasupukumkuma.req.transactional.PujaOrderReq;
import com.visog.pasupukumkuma.res.transactional.PujaOrderRes;
import com.visog.pasupukumkuma.service.transactional.PujaOrderService;
import com.visog.pasupukumkuma.utils.DaoUtils;



public class PujaOrderServiceImpl implements PujaOrderService {
	
	private static final Logger logger = Logger.getLogger(PujaOrderServiceImpl.class);
	
	@Inject
	private PujaOrderDao dao;

	public void savePujaOrder(PujaOrderReq req) {
		
		PujaOrder pujaorder = new PujaOrder();
		
		Users users = new Users();
		users.setId(req.getUser());
		pujaorder.setUser(users);
		
		Puja puja = new Puja();
		puja.setId(req.getPuja());
		pujaorder.setPuja(puja);
		
		pujaorder.setAmount(req.getAmount());
		pujaorder.setPayed(req.getPayed());
		
		Status status = new Status();
		status.setId(req.getStatus());
		pujaorder.setStatus(status);;
		
		
		DaoUtils.setEntityCreateAuditColumns(pujaorder);
		dao.save(pujaorder);
		
		logger.info("Puja Order is created Successfully"+pujaorder.getId());			
	}

	public Boolean updatePujaOrder(PujaOrderReq req, String pujaOrderId) {
		
		PujaOrder pujaorder =(PujaOrder)dao.getByKey(PujaOrder.class, pujaOrderId);
		
		Users users = new Users();
		users.setId(req.getUser());
		pujaorder.setUser(users);
		
		Puja puja = new Puja();
		puja.setId(req.getPuja());
		pujaorder.setPuja(puja);
		
		pujaorder.setAmount(req.getAmount());
		pujaorder.setPayed(req.getPayed());
		
		Status status = new Status();
		status.setId(req.getStatus());
		pujaorder.setStatus(status);
		
		dao.update(pujaorder);
		logger.info("Puja Order is updated Successfully"+pujaorder.getId());			
		
		return null;
	}

	public List<PujaOrderRes> getPujaOrder() {
		List<PujaOrder> pujaorder = dao.getPujaOrder();
		List<PujaOrderRes> pujaorderlist = new ArrayList<>();
		PujaOrderRes pujaOrderRes = null;
		
		for(PujaOrder pujaorders:pujaorder){
			pujaOrderRes =new PujaOrderRes();
			
			pujaOrderRes.setId(pujaorders.getId());
			pujaOrderRes.setUser(pujaorders.getUser().getId());
			pujaOrderRes.setPuja(pujaorders.getPuja().getId());
			pujaOrderRes.setAmount(pujaorders.getAmount());
			pujaOrderRes.setPayed(pujaorders.getPayed());
			pujaOrderRes.setStatus(pujaorders.getStatus().getId());
			pujaorderlist.add(pujaOrderRes);
			
		}
		return pujaorderlist;
	}

	public PujaOrderRes getPujaOrder(String id) {
		
		PujaOrder pujaorder =(PujaOrder)dao.getByKey(PujaOrder.class, id);
		PujaOrderRes pujaOrderRes = new PujaOrderRes();
		pujaOrderRes.setId(pujaorder.getId());
		pujaOrderRes.setUser(pujaorder.getUser().getId());
		pujaOrderRes.setPuja(pujaorder.getPuja().getId());
		pujaOrderRes.setAmount(pujaorder.getAmount());
		pujaOrderRes.setPayed(pujaorder.getPayed());
		pujaOrderRes.setStatus(pujaorder.getStatus().getId());
		
		return pujaOrderRes;
	}

	public Boolean deletePujaOrder(String pujaorderId) {
		return (dao.delete(PujaOrder.class, pujaorderId) != 0);
		
	}

	
	
	

}
