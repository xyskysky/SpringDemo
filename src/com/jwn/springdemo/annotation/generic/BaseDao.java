package com.jwn.springdemo.annotation.generic;

public class BaseDao<T>
{
	public void save(T entity)
	{
		System.out.println("BaseDao----save----" + entity);
	}
}
