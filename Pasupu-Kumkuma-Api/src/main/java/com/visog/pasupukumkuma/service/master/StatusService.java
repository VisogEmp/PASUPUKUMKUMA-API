package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.StatusReq;
import com.visog.pasupukumkuma.res.StatusRes;

public interface StatusService {

	public void saveStatus(StatusReq req);

	public void updateStatus(StatusReq req, String statusId);

	public List<StatusRes> getStatus();

	public StatusRes getStatus(String id);

	public Boolean deleteStatus(String statusId);

}
