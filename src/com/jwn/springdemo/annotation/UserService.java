package com.jwn.springdemo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
   private UserDao userDao;
   
   public void addUser()
   {
	   System.out.println("添加新用户-----UserService");
	   userDao.save();
   }
}
