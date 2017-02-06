package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.NakshatramDao;
import com.visog.pasupukumkuma.model.master.Nakshatram;
import com.visog.pasupukumkuma.req.NakshatramReq;
import com.visog.pasupukumkuma.res.NakshatramRes;
import com.visog.pasupukumkuma.service.master.NakshatramService;
import com.visog.pasupukumkuma.utils.DaoUtils;


public class NakshatramSeviceImpl implements NakshatramService {

	private static final Logger logger = Logger.getLogger(NakshatramSeviceImpl.class);

	@Inject
	NakshatramDao dao;

	/**
	 * This method saves the Nakshyatram
	 */
	public void saveNakshatram(NakshatramReq req) {
		Nakshatram nakshatram = new Nakshatram();
		nakshatram.setName(req.getName());
		nakshatram.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(nakshatram);
		
		dao.save(nakshatram);

		logger.info("Role created successfully : " + nakshatram.getId());
	}
	

	/**
	 * This method updates the Nakshatram
	 */
	public void updateNakshatram(NakshatramReq req, String nakshatramId) {
		
		Nakshatram nakshatram = (Nakshatram) dao.getByKey(Nakshatram.class, nakshatramId);
		nakshatram.setName(req.getName());
		nakshatram.setDescription(req.getDescription());
		dao.update(nakshatram);
		logger.info("Role updated successfully : " + nakshatram.getId());
	}
	

	/**
	 * This method returns all the Nakshatram
	 */
	public List<NakshatramRes> getNakshatram() {

		List<Nakshatram> nakshatram = dao.getNakshatram();
		List<NakshatramRes> nakshatramList = new ArrayList<>();
		NakshatramRes nakshatramRes = null;

		for (Nakshatram nakshatrams : nakshatram) {
			nakshatramRes = new NakshatramRes();
			nakshatramRes.setId( nakshatrams.getId());
			nakshatramRes.setName(nakshatrams.getName());
			nakshatramRes.setDescription(nakshatrams.getDescription());
			nakshatramList.add(nakshatramRes);
		}

		return nakshatramList;
	}
	

	/**
	 * This method returns Role Details for the given Nakshatram id  
	 */
	public NakshatramRes getNakshatram(String id) {
		
		Nakshatram nakshatram = (Nakshatram) dao.getByKey(Nakshatram.class, id);
		NakshatramRes nakshatramRes = new NakshatramRes();
		nakshatramRes.setId(nakshatram.getId());
		nakshatramRes.setName(nakshatram.getName());
		nakshatramRes.setDescription(nakshatram.getDescription());
		return nakshatramRes;
	}
	

	/**
	 * This method deletes the given role  
	 */
	public Boolean deleteNakshatram(String nakshatramId) {
		
		return (dao.delete(Nakshatram.class, nakshatramId) != 0);
		
	}

}
