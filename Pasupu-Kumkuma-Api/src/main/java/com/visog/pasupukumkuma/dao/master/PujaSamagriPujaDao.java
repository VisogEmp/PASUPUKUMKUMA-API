package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.PujaSamagriPuja;
import com.visog.pasupukumkuma.model.master.State;

public interface PujaSamagriPujaDao extends AbstractDaoI {

     public List<PujaSamagriPuja> getPujaSamagriPuja();
	
}
