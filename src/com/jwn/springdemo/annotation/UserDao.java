package com.jwn.springdemo.annotation;

import org.springframework.stereotype.Service;

@Service
public class UserDao
{
	public void save()
	{
		System.out.println("�������û�-----UserDao");
	}
}
