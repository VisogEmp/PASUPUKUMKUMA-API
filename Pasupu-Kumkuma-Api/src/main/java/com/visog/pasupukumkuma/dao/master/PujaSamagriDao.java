package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.PujaSamagri;

public interface PujaSamagriDao extends AbstractDaoI {

	public List<PujaSamagri> getPujaSamagri();
	
	public Boolean isPujaSamagriExists(String name);
}
