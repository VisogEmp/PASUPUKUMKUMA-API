package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.PujaOrderDetailsDao;
import com.visog.pasupukumkuma.model.master.PujaSamagri;
import com.visog.pasupukumkuma.model.transactional.PujaOrder;
import com.visog.pasupukumkuma.model.transactional.PujaOrderDetails;
import com.visog.pasupukumkuma.req.transactional.PujaOrderDetailsReq;
import com.visog.pasupukumkuma.res.transactional.PujaOrderDetailsRes;
import com.visog.pasupukumkuma.service.transactional.PujaOrderDetailsService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class PujaOrderDetailsServiceImpl implements PujaOrderDetailsService {

	
	private static final Logger logger = Logger.getLogger(PujaOrderDetailsServiceImpl.class);

	@Inject
	private PujaOrderDetailsDao dao;

	public void savePujaOrderDetails(PujaOrderDetailsReq req) {

		PujaOrderDetails pujaorderdetails = new PujaOrderDetails();
		
		PujaOrder pujaorder = new PujaOrder();
		pujaorder.setId(req.getPujaOrder());
		pujaorderdetails.setPujaOrder(pujaorder);
		
		PujaSamagri pujasamagri = new PujaSamagri();
		pujasamagri.setId(req.getPujaSamagri());
		pujaorderdetails.setPujaSamagri(pujasamagri);
	
		
		DaoUtils.setEntityCreateAuditColumns(pujaorderdetails);
		dao.save(pujaorderdetails);
		logger.info("PujaOrderDetails created successfully : " + pujaorderdetails.getId());

	}

	public void updatePujaOrderDetails(PujaOrderDetailsReq req, String Id) {

		PujaOrderDetails pujaorderdetails = (PujaOrderDetails) dao.getByKey(PujaOrderDetails.class, Id);
		
		PujaOrder pujaorder = new PujaOrder();
		pujaorder.setId(req.getPujaOrder());
		pujaorderdetails.setPujaOrder(pujaorder);
		
		
		PujaSamagri pujasamagri = new PujaSamagri();
		pujasamagri.setId(req.getPujaOrder());
		pujaorderdetails.setPujaSamagri(pujasamagri);
	

		dao.update(pujaorderdetails);

		logger.info("PujaOrderDetails updated successfully : " + pujaorderdetails.getId());

	}

	public List<PujaOrderDetailsRes> getPujaOrderDetails() {

		List<PujaOrderDetails> pujaorderdetails = dao.getPujaOrderDetails();
		List<PujaOrderDetailsRes> pujaorderdetailsList = new ArrayList<>();
		PujaOrderDetailsRes pujaorderdetailsres = null;
		for (PujaOrderDetails pujaorderdetail : pujaorderdetails) {
			pujaorderdetailsres = new PujaOrderDetailsRes();
			pujaorderdetailsres.setId(pujaorderdetail.getId());
			pujaorderdetailsres.setPujaOrder(pujaorderdetail.getPujaOrder().getId());
			pujaorderdetailsres.setPujaSamagri(pujaorderdetail.getPujaSamagri().getId());
			
			
			pujaorderdetailsList.add(pujaorderdetailsres);

		}
		return pujaorderdetailsList;
	}

	public PujaOrderDetailsRes getPujaOrderDetails(String id) {
		PujaOrderDetails pujaorderdetails = (PujaOrderDetails) dao.getByKey(PujaOrderDetails.class, id);
		PujaOrderDetailsRes pujaorderdetailsres = new PujaOrderDetailsRes();
		pujaorderdetailsres.setId(pujaorderdetails.getId());
		pujaorderdetailsres.setPujaOrder(pujaorderdetails.getPujaOrder().getId());
		pujaorderdetailsres.setPujaSamagri(pujaorderdetails.getPujaSamagri().getId());
		
		
		
		return pujaorderdetailsres;
	}

	public Boolean deletePujaOrderDetails(String pujaorderdetailsId) {
		return (dao.delete(PujaOrderDetails.class, pujaorderdetailsId) !=0);
	}

}
