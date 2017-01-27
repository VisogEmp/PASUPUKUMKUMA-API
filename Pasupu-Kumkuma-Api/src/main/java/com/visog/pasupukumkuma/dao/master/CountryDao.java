package com.visog.pasupukumkuma.dao.master;

import java.util.List;

import com.visog.pasupukumkuma.dao.AbstractDaoI;
import com.visog.pasupukumkuma.model.master.Country;

public interface CountryDao extends AbstractDaoI{

	public List<Country> getCountries();
}
