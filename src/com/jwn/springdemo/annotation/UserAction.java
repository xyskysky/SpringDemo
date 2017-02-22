package com.jwn.springdemo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("userAction1")
public class UserAction
{
	@Autowired
	private UserService userService;
	public void execute()
	{
		System.out.println("Ω” ‹«Î«Û------UserAction");
		userService.addUser();
	}
}
