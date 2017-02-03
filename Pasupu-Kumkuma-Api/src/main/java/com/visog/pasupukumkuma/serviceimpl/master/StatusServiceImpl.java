package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.StatusDao;
import com.visog.pasupukumkuma.model.master.Status;
import com.visog.pasupukumkuma.req.StatusReq;
import com.visog.pasupukumkuma.res.StatusRes;
import com.visog.pasupukumkuma.service.master.StatusService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class StatusServiceImpl implements StatusService {

	private static final Logger logger = Logger.getLogger(StatusServiceImpl.class);

	@Inject
	StatusDao dao;

	public void saveStatus(StatusReq req) {
		Status status = new Status();
		status.setCode(req.getCode());
		status.setName(req.getName());
		status.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(status);

		dao.save(status);

		logger.info("Status created successfully : " + status.getId());

	}

	public void updateStatus(StatusReq req, String statusId) {

		Status status = (Status) dao.getByKey(Status.class, statusId);
		
		
		status.setCode(req.getCode());
		status.setName(req.getName());
		status.setDescription(req.getDescription());

		DaoUtils.setEntityUpdateAuditColumns(status);
		dao.update(status);
		logger.info("Status updated successfully : " + status.getId());
	}

	public List<StatusRes> getStatus() {

		List<Status> status = dao.getStatus();

		List<StatusRes> statusList = new ArrayList<>();
		StatusRes statusRes = null;

		for (Status statuss : status) {
			statusRes = new StatusRes();
			statusRes.setId(statuss.getId());
            statusRes.setName(statuss.getName());
            statusRes.setCode(statuss.getCode());
			statusRes.setDescription(statuss.getDescription());
			statusList.add(statusRes);
		}

		return statusList;

	}

	public StatusRes getStatus(String id) {
		Status status = (Status) dao.getByKey(Status.class, id);
		StatusRes statusRes = new StatusRes();
		statusRes.setId(status.getId());
		statusRes.setCode(status.getCode());
		statusRes.setName(status.getName());
		statusRes.setDescription(status.getDescription());
		return statusRes;

	}

	public Boolean deleteStatus(String statusId) {
		return (dao.delete(Status.class, statusId) != 0);
	}

}
