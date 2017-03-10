package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.PujaDao;
import com.visog.pasupukumkuma.model.master.Puja;
import com.visog.pasupukumkuma.model.master.Status;
import com.visog.pasupukumkuma.req.PujaReq;
import com.visog.pasupukumkuma.res.PujaRes;
import com.visog.pasupukumkuma.service.master.PujaService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class PujaServiceImpl implements PujaService{
	
	private static final Logger logger = Logger.getLogger(PujaServiceImpl.class);

	@Inject
	PujaDao dao;
	
	/**
	 * This method saves the Puja
	 */

	public Boolean savePuja(PujaReq req) {
		//UploadFileService  upf=new UploadFileService ();
		Puja puja = new Puja();
		puja.setName(req.getName());
		puja.setDescription(req.getDescription());
		puja.setPrice(req.getPrice());
		puja.setDuration(req.getDuration());
		puja.setPhoto(req.getPhoto());
		
	
	/*	puja.setPhoto(upf.uploadFile(req.getPhoto(), fileDetail));*/
		puja.setPujaCount(req.getPujaCount());
        
		Status status = new Status();
		status.setId(req.getStatus());
		puja.setStatus(status);
		DaoUtils.setEntityCreateAuditColumns(puja);

		if (dao.isPujaExists(req.getName())) {

			logger.info("puja already exist : " + puja.getId());
			return false;

		} else {
			dao.save(puja);

			logger.info("puja created successfully : " + puja.getId());
			return true;

		}

	
	}
	
	/**
	 * This method updates the puja
	 */

	public Boolean updatePuja(PujaReq req, String pujaId) {
		
		Puja puja = (Puja) dao.getByKey(Puja.class, pujaId);
		logger.info("puja exist : " + puja.getName().toLowerCase().trim());
		logger.info("puja new : " + req.getName().toLowerCase().trim());

		if (puja.getName().toLowerCase().trim().equals(req.getName().toLowerCase().trim())
				|| (!dao.isPujaExists(req.getName()))) {

			puja.setName(req.getName());
			puja.setDescription(req.getDescription());
			puja.setPrice(req.getPrice());
			puja.setDuration(req.getDuration());
			puja.setPhoto(req.getPhoto());
			puja.setPujaCount(req.getPujaCount());
			
            Status status = new Status();
            status.setId(req.getStatus());

			puja.setStatus(status);

			dao.update(puja);
			logger.info("puja updated successfully : " + puja.getId());
			return true;

		} else {
			logger.info("puja already exist : " + puja.getId());
			return false;

		}

		
		
	}
	
	/**
	 * This method returns all the puja
	 */

	public List<PujaRes> getPuja() {
		
		List<Puja> pujas = dao.getPujas();

		List<PujaRes> pujaList = new ArrayList<>();
		PujaRes pujaRes = null;

		for (Puja puja : pujas) {
			pujaRes = new PujaRes();
			pujaRes.setId(puja.getId());
			pujaRes.setName(puja.getName());
			pujaRes.setDescription(puja.getDescription());
			pujaRes.setPrice(puja.getPrice());
			pujaRes.setDuration(puja.getDuration());
			pujaRes.setPhoto(puja.getPhoto());
			pujaRes.setPujaCount(puja.getPujaCount());
		    pujaRes.setStatus(puja.getStatus().getId());
			pujaList.add(pujaRes);
		}

		return pujaList;
		
	}
	
	/**
	 * This method returns Puja Details for the given puja id
	 */

	public PujaRes getPuja(String id) {
		
		Puja puja = (Puja) dao.getByKey(Puja.class, id);

		PujaRes pujaRes = new PujaRes();
		pujaRes.setId(puja.getId());
		pujaRes.setName(puja.getName());
		pujaRes.setDescription(puja.getDescription());
		pujaRes.setPrice(puja.getPrice());
		pujaRes.setDuration(puja.getDuration());
		pujaRes.setPhoto(puja.getPhoto());
		pujaRes.setPujaCount(puja.getPujaCount());
		pujaRes.setStatus(puja.getStatus().getId());
		return pujaRes;
		
	}
	
	/**
	 * This method deletes the given puja
	 */

	public Boolean deletePuja(String pujaId) {
		
		return (dao.delete(Puja.class, pujaId) != 0);
	}

	

	

}
