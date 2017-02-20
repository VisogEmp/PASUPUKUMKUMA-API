package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.PujaSamagriDao;
import com.visog.pasupukumkuma.dao.master.RoleDao;
import com.visog.pasupukumkuma.model.master.Country;
import com.visog.pasupukumkuma.model.master.PujaSamagri;
import com.visog.pasupukumkuma.model.master.Roles;
import com.visog.pasupukumkuma.model.master.State;
import com.visog.pasupukumkuma.model.master.Status;
import com.visog.pasupukumkuma.req.PujaSamagriReq;
import com.visog.pasupukumkuma.res.PujaSamagriRes;
import com.visog.pasupukumkuma.res.RolesRes;
import com.visog.pasupukumkuma.res.StateRes;
import com.visog.pasupukumkuma.service.master.PujaSamagriService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class PujaSamagriServiceImpl implements PujaSamagriService{

	private static final Logger logger = Logger.getLogger(PujaSamagriServiceImpl.class);

	@Inject
	PujaSamagriDao dao;

	
	public Boolean savePujaSamagri(PujaSamagriReq req) {

		PujaSamagri pujasamagri = new PujaSamagri();
		pujasamagri.setName(req.getName());
		pujasamagri.setDescription(req.getDescription());
		pujasamagri.setPrice(req.getPrice());
		pujasamagri.setDuration(req.getDuration());
		pujasamagri.setPhoto(req.getPhoto());
		pujasamagri.setSamagriCount(req.getSamagriCount());
		
		Status status = new Status();
		status.setId(req.getStatus());
		pujasamagri.setStatus(status);
		DaoUtils.setEntityCreateAuditColumns(pujasamagri);

		if (dao.isPujaSamagriExists(req.getName())) {

			logger.info("State already exist : " + pujasamagri.getId());
			return false;

		} else {
			dao.save(pujasamagri);

			logger.info("state created successfully : " + pujasamagri.getId());
			return true;

		}
		
	}
	/**
	 * This method updates the Pujasamagri
	 */
	
	public Boolean updatePujaSamagri(PujaSamagriReq req, String pujasamagriId) {

		PujaSamagri pujasamagri = (PujaSamagri) dao.getByKey(PujaSamagri.class, pujasamagriId);
		logger.info("pujasamagri exist : " + pujasamagri.getName().toLowerCase().trim());
		logger.info("pujasamagri new : " + req.getName().toLowerCase().trim());

		if (pujasamagri.getName().toLowerCase().trim().equals(req.getName().toLowerCase().trim())
				|| (!dao.isPujaSamagriExists(req.getName()))) {

			pujasamagri.setName(req.getName());
			pujasamagri.setDescription(req.getDescription());
			pujasamagri.setPrice(req.getPrice());
			pujasamagri.setDuration(req.getDuration());
			pujasamagri.setPhoto(req.getPhoto());
			pujasamagri.setSamagriCount(req.getSamagriCount());

			Status status = new Status();
			status.setId(req.getStatus());

			pujasamagri.setStatus(status);

			dao.update(pujasamagri);
			logger.info("pujasamagri updated successfully : " + pujasamagri.getId());
			return true;

		} else {
			logger.info("pujasamagri already exist : " + pujasamagri.getId());
			return false;

		}

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
			pujasamagriRes.setSamagriCount(pujasamagris.getSamagriCount());
			
			pujasamagriRes.setStatus(pujasamagris.getStatus().getId());
			pujasamagriList.add(pujasamagriRes);
		}

		return pujasamagriList;
	}

	/**
	 * This method returns State Details for the given pujasamagri id
	 */
	
	public PujaSamagriRes getPujaSamagri(String id) {
		
		PujaSamagri pujasamagris = (PujaSamagri) dao.getByKey(PujaSamagri.class, id);

		PujaSamagriRes pujasamagriRes = new PujaSamagriRes();
		pujasamagriRes.setId(pujasamagris.getId());
		pujasamagriRes.setName(pujasamagris.getName());
		pujasamagriRes.setDescription(pujasamagris.getDescription());
		pujasamagriRes.setPrice(pujasamagris.getPrice());
		pujasamagriRes.setDuration(pujasamagris.getDuration());
		pujasamagriRes.setPhoto(pujasamagris.getPhoto());
		pujasamagriRes.setSamagriCount(pujasamagris.getSamagriCount());
		pujasamagriRes.setStatus(pujasamagris.getStatus().getId());
		return pujasamagriRes;
	}

	/**
	 * This method deletes the given pujasamagri
	 */
	public Boolean deletePujaSamagri(String pujasamagriId) {

		return (dao.delete(PujaSamagri.class, pujasamagriId) != 0);
	}

	
	

}
