package com.jwn.springdemo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction
{
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public void execute()
	{
		System.out.println("Ω” ‹«Î«Û------UserAction");
		userService.addUser();
	}
}
