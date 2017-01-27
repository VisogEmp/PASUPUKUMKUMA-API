package com.visog.pasupukumkuma.dao;

public interface AbstractDaoI {

	public Object getByKey(Class persistentClass, String key);

	public void save(Object entity);
	
	public void update(Object entity);

	public Integer delete(Class persistentClass, String key);
	
}
