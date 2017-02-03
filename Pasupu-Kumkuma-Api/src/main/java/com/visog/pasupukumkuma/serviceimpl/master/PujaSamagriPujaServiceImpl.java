package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.PujaSamagriPujaDao;
import com.visog.pasupukumkuma.model.master.Country;
import com.visog.pasupukumkuma.model.master.Puja;
import com.visog.pasupukumkuma.model.master.PujaSamagri;
import com.visog.pasupukumkuma.model.master.PujaSamagriPuja;
import com.visog.pasupukumkuma.model.master.State;
import com.visog.pasupukumkuma.model.master.Status;
import com.visog.pasupukumkuma.req.PujaSamagriPujaReq;
import com.visog.pasupukumkuma.res.PujaSamagriPujaRes;
import com.visog.pasupukumkuma.res.StateRes;
import com.visog.pasupukumkuma.service.master.PujaSamagriPujaService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class PujaSamagriPujaServiceImpl implements PujaSamagriPujaService {

private static final Logger logger = Logger.getLogger(PujaSamagriPujaServiceImpl.class);
	
	@Inject
	private PujaSamagriPujaDao dao;
	
	public void savePujaSamagriPuja(PujaSamagriPujaReq req) {

		PujaSamagriPuja pujasamagripuja = new PujaSamagriPuja();
		
		PujaSamagri pujasamagri = new PujaSamagri();
		pujasamagri.setId(req.getPujasamagri());
		pujasamagripuja.setPujasamagri(pujasamagri);
		
		Puja puja = new Puja();
		puja.setId(req.getPujas());
		pujasamagripuja.setPujas(puja);
		
		Status status = new Status();
		status.setId(req.getStatus());
		pujasamagripuja.setStatus(status);
		
		DaoUtils.setEntityCreateAuditColumns(pujasamagripuja);

		dao.save(pujasamagripuja);
		
	
	}
	/**
	 * This method updates the pujasamagripuja
	 */
	
	public void updatePujaSamagriPuja(PujaSamagriPujaReq req,
			String pujasamagripujaId) {

		PujaSamagriPuja pujasamagripuja = (PujaSamagriPuja) dao.getByKey(PujaSamagriPuja.class,pujasamagripujaId);
		

		PujaSamagri pujasamagri = new PujaSamagri();
		pujasamagri.setId(req.getPujasamagri());
		pujasamagripuja.setPujasamagri(pujasamagri);
		
		Puja puja = new Puja();
		puja.setId(req.getPujas());
		pujasamagripuja.setPujas(puja);
		
		Status status = new Status();
		status.setId(req.getStatus());
		pujasamagripuja.setStatus(status);
		
		dao.update(pujasamagripuja);

	}
	/**
	 * This method returns all the pujasamagripuja
	 */
	
	public List<PujaSamagriPujaRes> getPujaSamagriPuja() {

		List<PujaSamagriPuja> pujaSamagriPuja = dao.getPujaSamagriPuja();

		List<PujaSamagriPujaRes> pujaSamagriPujaList = new ArrayList<>();
		PujaSamagriPujaRes pujaSamagriPujaRes = null;

		for (PujaSamagriPuja pujaSamagriPujas : pujaSamagriPuja) {
			pujaSamagriPujaRes = new PujaSamagriPujaRes();
			pujaSamagriPujaRes.setId(pujaSamagriPujas.getId());
			
			pujaSamagriPujaRes.setPujasamagri(pujaSamagriPujas.getPujasamagri().getId());
			pujaSamagriPujaRes.setPujas(pujaSamagriPujas.getPujas().getId());
			pujaSamagriPujaRes.setStatus(pujaSamagriPujas.getStatus().getId());
			
			pujaSamagriPujaList.add(pujaSamagriPujaRes);
			
		}

		return pujaSamagriPujaList;
	}
	/**
	 * This method returns State Details for the given pujasamagripuja id
	 */
	
	public PujaSamagriPujaRes getPujaSamagriPuja(String id) {

		PujaSamagriPuja pujaSamagriPuja = (PujaSamagriPuja) dao.getByKey(PujaSamagriPuja.class, id);

		PujaSamagriPujaRes pujaSamagriPujaRes = new PujaSamagriPujaRes();
		pujaSamagriPujaRes.setId(pujaSamagriPuja.getId());
		
		pujaSamagriPujaRes.setPujasamagri(pujaSamagriPuja.getPujasamagri().getId());
		pujaSamagriPujaRes.setPujas(pujaSamagriPuja.getPujas().getId());
		pujaSamagriPujaRes.setStatus(pujaSamagriPuja.getStatus().getId());
		
		
		return pujaSamagriPujaRes;
	}

	/**
	 * This method deletes the given pujasamagripuja
	 */
	
	public Boolean deletePujaSamagriPuja(String pujasamagripujaId) {

		return (dao.delete(PujaSamagriPuja.class, pujasamagripujaId) != 0);
	}

}
