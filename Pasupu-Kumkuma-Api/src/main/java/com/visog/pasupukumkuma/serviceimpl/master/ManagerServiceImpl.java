package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.Managerdao;
import com.visog.pasupukumkuma.model.master.Manager;
import com.visog.pasupukumkuma.req.ManagerReq;
import com.visog.pasupukumkuma.res.ManagerRes;
import com.visog.pasupukumkuma.service.master.ManagerService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class ManagerServiceImpl implements ManagerService {

	private static final Logger logger = Logger
			.getLogger(ManagerServiceImpl.class);

	@Inject
	Managerdao dao;

	public void saveManager(ManagerReq req) {

		Manager manager = new Manager();

		manager.setName(req.getName());
		manager.setEmail(req.getEmail());

		DaoUtils.setEntityCreateAuditColumns(manager);
		dao.save(manager);

		logger.info("Manager Created Successfully" + manager.getId());

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateManager(ManagerReq req, String managerId) {

		Manager manager = (Manager) dao.getByKey(Manager.class, managerId);

		manager.setName(req.getName());
		manager.setEmail(req.getEmail());

		
		dao.save(manager);

		logger.info("Manager Updated Successfully" + manager.getId());

	}

	public List<ManagerRes> getManagers() {
		
		List<Manager> manager =dao.getManagers();
		
		List<ManagerRes> managersList = new ArrayList<>();
		ManagerRes managerRes = null;
		
		for (Manager managers : manager) {
			managerRes = new ManagerRes();
			managerRes.setId(managers.getId());
			managerRes.setName(managers.getName());
			managerRes.setEmail(managers.getEmail());
			managersList.add(managerRes);
		}

		return managersList;

		
	}

	/*public ManagerRes getRole(String id) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Boolean deleteManagers(String managerId) {
		// TODO Auto-generated method stub
		return (dao.delete(Manager.class, managerId) !=0);
	}

}
