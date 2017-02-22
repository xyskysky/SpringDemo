package com.jwn.springdemo.ref;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.jwn.springdemo.helloworld.User;

public class MyBeanPostProcessor implements BeanPostProcessor
{

	// �÷����� init-method����֮����� arg1 Ϊbean������ arg0 ΪҪ���ص�bean����
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException
	{
		if (arg1.equals("boy"))
		{
			System.out.println("postProcessAfterInitialzation========"+arg0+"   ,"+arg1);
			User user=(User) arg0;
			user.setUserName("�����ʥ�����");
		}
		return arg0;
	}

	// �÷����� init-method����֮ǰ����
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
