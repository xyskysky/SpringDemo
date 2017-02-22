package com.jwn.springdemo.annotation.generic;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T>
{
	@Autowired
	private BaseDao<T> baseDao;
	
	public void addNew(T entity)
	{
		System.out.println("BaseService-----addNew-----"+entity);
		baseDao.save(entity);
	}
}
