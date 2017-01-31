package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.PujasDao;
import com.visog.pasupukumkuma.model.master.Puja;
import com.visog.pasupukumkuma.model.master.Roles;
import com.visog.pasupukumkuma.req.PujaReq;
import com.visog.pasupukumkuma.res.PujaRes;
import com.visog.pasupukumkuma.res.RolesRes;
import com.visog.pasupukumkuma.service.master.PujasService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class PujasServiceImpl implements PujasService{
	
	private static final Logger logger = Logger.getLogger(PujasServiceImpl.class);

	@Inject
	PujasDao dao;

	/**
	 * This method saves the Pujas
	 */

	public void savePujas(PujaReq req) {
		
		Puja pujas = new Puja();
		pujas.setName(req.getName());
		pujas.setDescription(req.getDescription());
		pujas.setPrice(req.getPrice());
		pujas.setDuration(req.getDuration());
		pujas.setPhoto(req.getPhoto());
		

		DaoUtils.setEntityCreateAuditColumns(pujas);
		
		dao.save(pujas);

		logger.info("Pujas created successfully : " + pujas.getId());
		
	}

	/**
	 * This method updates the Pujas
	 */
	public void updatePujas(PujaReq req, String pujasId) {
		
		Puja pujas = (Puja) dao.getByKey(Puja.class, pujasId);
		pujas.setName(req.getName());
		pujas.setDescription(req.getDescription());
		pujas.setPrice(req.getPrice());
		pujas.setDuration(req.getDuration());
		pujas.setPhoto(req.getPhoto());
		

		dao.update(pujas);
		logger.info("Pujas updated successfully : " + pujas.getId());
		
	}

	public List<PujaRes> getPujas() {
		
		List<Puja> pujas = dao.getPujas();

		List<PujaRes> pujasList = new ArrayList<>();
		PujaRes pujasRes = null;

		for (Puja puja : pujas) {
			pujasRes = new PujaRes();
			pujasRes.setId(puja.getId());
			pujasRes.setName(puja.getName());
			pujasRes.setDescription(puja.getDescription());
			pujasRes.setPrice(puja.getPrice());
			pujasRes.setDuration(puja.getDuration());
			pujasRes.setPhoto(puja.getPhoto());
			
			
			pujasList.add(pujasRes);
		}

		return pujasList;
		
	}
	
	/**
	 * This method returns Pujas Details for the given puja id  
	 */

	public PujaRes getPujas(String id) {
		
		Puja puja = (Puja) dao.getByKey(Puja.class, id);
		PujaRes pujaRes = new PujaRes();
		pujaRes.setId(puja.getId());
		pujaRes.setName(puja.getName());
		pujaRes.setDescription(puja.getDescription());
		pujaRes.setPrice(puja.getPrice());
		pujaRes.setDuration(puja.getDuration());
		return pujaRes;
	}
	
	/**
	 * This method deletes the given puja  
	 */

	public Boolean deletePujas(String pujasId) {
		return (dao.delete(Puja.class, pujasId) != 0);
	}
	
	

}
