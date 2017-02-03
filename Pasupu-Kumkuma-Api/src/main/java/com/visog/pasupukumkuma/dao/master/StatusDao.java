package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Status;

public interface StatusDao extends AbstractDaoI {

	public List<Status> getStatus();

}
