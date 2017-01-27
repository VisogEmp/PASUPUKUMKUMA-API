package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.ManagerReq;
import com.visog.pasupukumkuma.res.ManagerRes;


public interface ManagerService {

	public void saveManager(ManagerReq req);

	public void updateManager(ManagerReq req, String managerId);

	public List<ManagerRes> getManagers();

	/* public ManagerRes getRole(String id); */

	public Boolean deleteManagers(String managerId);

}
