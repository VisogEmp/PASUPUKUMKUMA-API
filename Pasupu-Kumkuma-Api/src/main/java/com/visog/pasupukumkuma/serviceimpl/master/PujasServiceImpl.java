package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.PujasDao;
import com.visog.pasupukumkuma.model.master.Pujas;
import com.visog.pasupukumkuma.model.master.Roles;
import com.visog.pasupukumkuma.req.PujasReq;
import com.visog.pasupukumkuma.res.PujasRes;
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

	public void savePujas(PujasReq req) {
		
		Pujas pujas = new Pujas();
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
	public void updatePujas(PujasReq req, String pujasId) {
		
		Pujas pujas = (Pujas) dao.getByKey(Pujas.class, pujasId);
		pujas.setName(req.getName());
		pujas.setDescription(req.getDescription());
		pujas.setPrice(req.getPrice());
		pujas.setDuration(req.getDuration());
		pujas.setPhoto(req.getPhoto());
		

		dao.update(pujas);
		logger.info("Pujas updated successfully : " + pujas.getId());
		
	}

	public List<PujasRes> getPujas() {
		
		List<Pujas> pujas = dao.getPujas();

		List<PujasRes> pujasList = new ArrayList<>();
		PujasRes pujasRes = null;

		for (Pujas puja : pujas) {
			pujasRes = new PujasRes();
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

	public PujasRes getPujas(String id) {
		
		Pujas puja = (Pujas) dao.getByKey(Pujas.class, id);
		PujasRes pujaRes = new PujasRes();
		pujaRes.setId(puja.getId());
		pujaRes.setName(puja.getName());
		pujaRes.setDescription(puja.getDescription());
		pujaRes.setPrice(puja.getPrice());
		pujaRes.setDuration(puja.getDuration());
		return pujaRes;
	}

	public Boolean deletePujas(String pujasId) {
		return null;
	}
	
	

}
