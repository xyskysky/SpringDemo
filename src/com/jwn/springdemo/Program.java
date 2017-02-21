package com.jwn.springdemo;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jwn.springdemo.helloworld.Car;
import com.jwn.springdemo.helloworld.HelloWorld;
import com.jwn.springdemo.helloworld.User;

public class Program
{

	public static void beansHelloWorld()
	{
		//加载容器时  对象已经初始化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-helloworld.xml");
		HelloWorld helloWorld1 = (HelloWorld) ctx.getBean("helloworld1");
		System.out.println(helloWorld1);
		HelloWorld helloWorld2=(HelloWorld) ctx.getBean("helloworld2");
		System.out.println(helloWorld2);
		//类型中必须只有一个类型的bean
		//HelloWorld helloWrold3=ctx.getBean(HelloWorld.class);
		//System.out.println(helloWrold3);
		HelloWorld helloWorld4=(HelloWorld) ctx.getBean("helloworld3");
		System.out.println(helloWorld4);
		
	}
	public static void beansCar()
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-helloworld.xml");
//		Car car1=(Car) ctx.getBean("car1");
//		System.out.println(car1);
//		Car car2=(Car) ctx.getBean("car2");
//		System.out.println(car2);
//		
//		Car car3=(Car) ctx.getBean("car3");
//		System.out.println(car3);
		List<Car> cars1 = (List<Car>) ctx.getBean("cars");
		for(Car car:cars1)
		{
			System.out.println(car);
		}
		System.out.println("==============================");
		Map<String, Car> cars2=(Map<String, Car>) ctx.getBean("cars2");
		for(Map.Entry<String, Car> entry:cars2.entrySet())
		{
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println("==================================");
		User user1=(User) ctx.getBean("user1");
		System.out.println(user1);
		
	}
	

	public static void main(String[] args)
	{
		beansCar();
		//beansHelloWorld();
	}

}
