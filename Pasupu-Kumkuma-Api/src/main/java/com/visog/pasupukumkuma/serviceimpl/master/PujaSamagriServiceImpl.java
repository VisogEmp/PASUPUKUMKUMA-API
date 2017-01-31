package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.PujaSamagriDao;
import com.visog.pasupukumkuma.dao.master.RoleDao;
import com.visog.pasupukumkuma.model.master.PujaSamagri;
import com.visog.pasupukumkuma.model.master.Roles;
import com.visog.pasupukumkuma.req.PujaSamagriReq;
import com.visog.pasupukumkuma.res.PujaSamagriRes;
import com.visog.pasupukumkuma.res.RolesRes;
import com.visog.pasupukumkuma.service.master.PujaSamagriService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class PujaSamagriServiceImpl implements PujaSamagriService{

	private static final Logger logger = Logger.getLogger(PujaSamagriServiceImpl.class);

	@Inject
	PujaSamagriDao dao;

	/**
	 * This method saves the pujasamagri
	 */
	
	public void savePujaSamagri(PujaSamagriReq req) {
		
		PujaSamagri pujasamagri = new PujaSamagri();
		pujasamagri.setName(req.getName());
		pujasamagri.setDescription(req.getDescription());
		pujasamagri.setPrice(req.getPrice());
		pujasamagri.setDuration(req.getDuration());
		pujasamagri.setPhoto(req.getPhoto());
		pujasamagri.setSamagri_count(req.getSamagri_count());
		//pujasamagri.setStatus(req.getStatus());

		DaoUtils.setEntityCreateAuditColumns(pujasamagri);
		
		dao.save(pujasamagri);

		logger.info("PujaSamagri created successfully : " + pujasamagri.getId());
	}

	/**
	 * This method updates the PujaSamagri
	 */
	
	public void updatePujaSamagri(PujaSamagriReq req, String pujasamagriId) {

		PujaSamagri pujasamagri = (PujaSamagri) dao.getByKey(PujaSamagri.class, pujasamagriId);
		pujasamagri.setName(req.getName());
		pujasamagri.setDescription(req.getDescription());
		pujasamagri.setPrice(req.getPrice());
		pujasamagri.setDuration(req.getDuration());
		pujasamagri.setPhoto(req.getPhoto());
		pujasamagri.setSamagri_count(req.getSamagri_count());
		//pujasamagri.setStatus(req.getStatus());
		dao.update(pujasamagri);
		logger.info("PujaSamagri updated successfully : " + pujasamagri.getId());
	}
	/**
	 * This method returns all the pujasamagri
	 */
	
	public List<PujaSamagriRes> getPujaSamagri() {

		List<PujaSamagri> pujasamagri = dao.getPujaSamagri();

		List<PujaSamagriRes> pujasamagriList = new ArrayList<>();
		PujaSamagriRes pujasamagriRes = null;

		for (PujaSamagri pujasamagris : pujasamagri) {
			pujasamagriRes = new PujaSamagriRes();
			pujasamagriRes.setId(pujasamagris.getId());
			pujasamagriRes.setName(pujasamagris.getName());
			pujasamagriRes.setDescription(pujasamagris.getDescription());
			pujasamagriRes.setPrice(pujasamagris.getPrice());
			pujasamagriRes.setDuration(pujasamagris.getDuration());
			pujasamagriRes.setPhoto(pujasamagris.getPhoto());
			pujasamagriRes.setSamagri_count(pujasamagris.getSamagri_count());
			//pujasamagriRes.setStatus(pujasamagris.getStatus());
			
			pujasamagriList.add(pujasamagriRes);
		}

		return pujasamagriList;
		
	}

	/**
	 * This method returns Role Details for the given pujasamagri id  
	 */
	
	public PujaSamagriRes getPujaSamagri(String id) {

		PujaSamagri pujasamagri = (PujaSamagri) dao.getByKey(PujaSamagri.class, id);
		PujaSamagriRes pujasamagriRes = new PujaSamagriRes();
		pujasamagriRes.setId(pujasamagri.getId());
		pujasamagriRes.setName(pujasamagri.getName());
		pujasamagriRes.setDescription(pujasamagri.getDescription());
		pujasamagriRes.setPrice(pujasamagri.getPrice());
		pujasamagriRes.setDuration(pujasamagri.getDuration());
		pujasamagriRes.setPhoto(pujasamagri.getPhoto());
		pujasamagriRes.setSamagri_count(pujasamagri.getSamagri_count());
		//pujasamagriRes.setStatus(pujasamagri.getStatus());
		return pujasamagriRes;
		
	}

	/**
	 * This method deletes the given pujasamagri  
	 */
	
	public Boolean deletePujaSamagri(String pujasamagriId) {

		return (dao.delete(PujaSamagri.class, pujasamagriId) != 0);
	}

}
