package com.jwn.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jwn.springdemo.aop.xml.ArithmeticCalculator;

public class Main
{

	public static void beansAopXml()
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-aop-xml.xml");
		ArithmeticCalculator bean = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		int add = bean.add(10, 10);
		System.out.println("add====result===="+add);
		System.out.println("======================================================");
		//bean.div(100, 0);
	}
	public static void main(String[] args)
	{
		beansAopXml();
	}

}
