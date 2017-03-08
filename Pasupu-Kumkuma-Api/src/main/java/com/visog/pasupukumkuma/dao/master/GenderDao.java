package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Gender;
import com.visog.pasupukumkuma.res.GenderRes;

public interface GenderDao extends AbstractDaoI {

	public List<Gender> getGenders();

	public Boolean isGenderExists(String name);

}
