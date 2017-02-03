package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.RaasiDao;
import com.visog.pasupukumkuma.model.master.Raasi;
import com.visog.pasupukumkuma.req.RaasiReq;
import com.visog.pasupukumkuma.res.RaasiRes;
import com.visog.pasupukumkuma.service.master.RaasiService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class RaasiSeviceImpl implements RaasiService {

	private static final Logger logger = Logger.getLogger(RaasiSeviceImpl.class);

	@Inject
	RaasiDao dao;

	
	public List<RaasiRes> getRaasi() {

		List<Raasi> raasi = dao.getRaasi();

		List<RaasiRes> raasiList = new ArrayList<>();
		RaasiRes raasiRes = null;

		for (Raasi raasis : raasi) {
			raasiRes=new RaasiRes();
			
			raasiRes.setId(raasis.getId());
			raasiRes.setName(raasis.getName());
			raasiRes.setDescription(raasis.getDescription());
			raasiList.add(raasiRes);
		}
		return raasiList;
	}

	

	public void saveRaasi(RaasiReq req) {
		
		Raasi raasi = new Raasi();
		raasi.setName(req.getName());
		raasi.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(raasi);		
		dao.save(raasi);
		logger.info("Role created successfully : " + raasi.getId());
	}

	public void updateRaasi(RaasiReq req, String raasiId) {
		Raasi raasi = (Raasi) dao.getByKey(Raasi.class,raasiId);
		raasi.setName(req.getName());
		raasi.setDescription(req.getDescription());
		dao.update(raasi);
		logger.info("Role updated successfully : " + raasi.getId());
	}

	public RaasiRes getRaasi(String id) {
		
		Raasi raasi = (Raasi) dao.getByKey(Raasi.class, id);
		RaasiRes raasiRes = new RaasiRes();
		raasiRes.setId(raasi.getId());
		raasiRes.setName(raasi.getName());
		raasiRes.setDescription(raasi.getDescription());
		return raasiRes;
	}

	public Boolean deleteRaasi(String raasiId) {
		return (dao.delete(Raasi.class, raasiId) != 0);
	}

}
