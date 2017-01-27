package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.RolesReq;
import com.visog.pasupukumkuma.res.RolesRes;


public interface RolesService {
	
	public void saveRole(RolesReq req);
	
	public void updateRole(RolesReq req, String roleId);
	
	public List<RolesRes> getRoles();
	
	public RolesRes getRole(String id);
	
	public Boolean deleteRole(String roleId);
	
}
