package com.jwn.springdemo.ref;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.jwn.springdemo.helloworld.User;

public class MyBeanPostProcessor implements BeanPostProcessor
{

	// 该方法在 init-method方法之后调用 arg1 为bean的名字 arg0 为要返回的bean对象
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException
	{
		if (arg1.equals("boy"))
		{
			System.out.println("postProcessAfterInitialzation========"+arg0+"   ,"+arg1);
			User user=(User) arg0;
			user.setUserName("齐天大圣素悟空");
		}
		return arg0;
	}

	// 该方法在 init-method方法之前调用
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException
	{
		if(arg1.equals("boy"))
		{
		System.out.println(
				"postProcessBeforeInitialization========"+arg0+"    ,"+arg1);
		
		
		}
		return arg0;
	}

}
