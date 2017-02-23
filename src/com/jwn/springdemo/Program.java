package com.jwn.springdemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jwn.springdemo.annotation.UserAction;
import com.jwn.springdemo.annotation.generic.Role;
import com.jwn.springdemo.annotation.generic.RoleService;
import com.jwn.springdemo.annotation.generic.UserService;
import com.jwn.springdemo.aop.ArithmeticCalculator;
import com.jwn.springdemo.aop.ArithmeticCalculatorImpl;
import com.jwn.springdemo.aop.ArithmeticCalculatorLoggingProxy;
import com.jwn.springdemo.helloworld.Car;
import com.jwn.springdemo.helloworld.Hello;
import com.jwn.springdemo.helloworld.HelloWorld;
import com.jwn.springdemo.helloworld.User;
import com.jwn.springdemo.ref.Action;
import com.jwn.springdemo.ref.Dao;
import com.jwn.springdemo.ref.Service;

public class Program
{

	public static void beansHelloWorld()
	{
		// 加载容器时 对象已经初始化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-helloworld.xml");
		HelloWorld helloWorld1 = (HelloWorld) ctx.getBean("helloworld1");
		System.out.println(helloWorld1);
		HelloWorld helloWorld2 = (HelloWorld) ctx.getBean("helloworld2");
		System.out.println(helloWorld2);
		// 类型中必须只有一个类型的bean
		// HelloWorld helloWrold3=ctx.getBean(HelloWorld.class);
		// System.out.println(helloWrold3);
		HelloWorld helloWorld4 = (HelloWorld) ctx.getBean("helloworld3");
		System.out.println(helloWorld4);

	}

	public static void beansCar()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-helloworld.xml");
		// Car car1=(Car) ctx.getBean("car1");
		// System.out.println(car1);
		// Car car2=(Car) ctx.getBean("car2");
		// System.out.println(car2);
		//
		// Car car3=(Car) ctx.getBean("car3");
		// System.out.println(car3);
		// List<Car> cars1 = (List<Car>) ctx.getBean("cars");
		// for(Car car:cars1)
		// {
		// System.out.println(car);
		// }
		// System.out.println("==============================");
		// Map<String, Car> cars2=(Map<String, Car>) ctx.getBean("cars2");
		// for(Map.Entry<String, Car> entry:cars2.entrySet())
		// {
		// System.out.println(entry.getKey()+":"+entry.getValue());
		// }
		// System.out.println("==================================");
		// User user1=(User) ctx.getBean("user1");
		// System.out.println(user1);

		// User user2=(User) ctx.getBean("user2");
		// System.out.println(user2);

		// User user4=(User) ctx.getBean("user");
		// System.out.println(user4);
		// User user5=(User) ctx.getBean("user4");
		//
		// User user6=(User) ctx.getBean("user4");
		//
		// System.out.println(user5==user6);

		User user7 = (User) ctx.getBean("user5");
		System.out.println(user7);
	}

	public static void beansDao()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-helloworld.xml");
		Dao dao1 = (Dao) ctx.getBean("dao");
		System.out.println(dao1);

		Service service1 = (Service) ctx.getBean("service2");
		System.out.println(service1);
		service1.save();
		System.out.println("====================================");
		Action action1 = (Action) ctx.getBean("action1");
		action1.execute();
	}

	public static void beansAuto()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-auto.xml");
		// Dao dao=(Dao) ctx.getBean("dao");
		// Dao dao1=(Dao) ctx.getBean("dao1");
		// Dao dao2=(Dao) ctx.getBean("dao");
		// Dao dao3=(Dao) ctx.getBean("dao1");
		//
		// System.out.println(dao+"=============="+dao1);
		// System.out.println(dao==dao2);
		// System.out.println(dao1==dao3);

		Service service1 = (Service) ctx.getBean("service1");
		service1.save();
		System.out.println("======================================");
		Action action1 = (Action) ctx.getBean("action");
		action1.execute();
	}

	public static void beansDataSource()
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-auto.xml");
		// DataSource dataSource1=(DataSource) ctx.getBean("dataSource");
		// System.out.println(dataSource1);
		// System.out.println("==============================");
		//
		// User girl=(User) ctx.getBean("girl");
		// System.out.println(girl);
		User boy = (User) ctx.getBean("boy");
		System.out.println(boy.getWifeName());
		System.out.println(boy);
		System.out.println("==================================");
		DateFormat dateFormat = (DateFormat) ctx.getBean("dateFormat");
		System.out.println(dateFormat.format(new Date()));
		System.out.println("=======================================");

		Date date = (Date) ctx.getBean("dateTime");
		System.out.println(date);

		System.out.println("===========================================");
		User user7 = (User) ctx.getBean("user7");
		System.out.println(user7);
		System.out.println("=================================");
		User user8 = (User) ctx.getBean("user8");
		System.out.println(user8);

		ctx.close();
	}

	public static void beansAnnotationh()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");

		UserAction userAction = ctx.getBean(UserAction.class);
		userAction.execute();
	}

	public static void beansGenericAnnotation()
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-annotation.xml");
		
		UserService userService=ctx.getBean(UserService.class);
		userService.addNew(new com.jwn.springdemo.annotation.generic.User());
		
		RoleService roleService=ctx.getBean(RoleService.class);
		roleService.addNew(new Role());
		System.out.println("==================================================");
		UserService userService2=(UserService) ctx.getBean("userService");
		userService2.addNew(new com.jwn.springdemo.annotation.generic.User());
		RoleService roleService2=(RoleService) ctx.getBean("roleService");
		roleService2.addNew(new Role());
		
	}
	public static void beansHello()
	{
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello=(Hello) ctx.getBean("hello");
		hello.hello();
		
		System.out.println("=======================================");
		UserAction userAciton=(UserAction) ctx.getBean("userAction");
		userAciton.execute();
		ctx.close();
		
	}
	public static void beansProxy()
	{
		//使用代理方法
		ArithmeticCalculatorLoggingProxy proxy=new ArithmeticCalculatorLoggingProxy(new ArithmeticCalculatorImpl());
		ArithmeticCalculator loggingProxy = proxy.getLoggingProxy();
		int add = loggingProxy.add(10, 2);
		System.out.println("add============"+add);
		loggingProxy.sum(10, 10);
		
		
		
	}
	public static void beansAspect()
	{
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-aop.xml");
		
		ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		int add = arithmeticCalculator.add(10, 10);
		System.out.println("resut==="+add);
		System.out.println("===================================================");
		arithmeticCalculator.sum(10, 30);
	}
	
	public static void main(String[] args)
	{
		
		
		beansAspect();
		//beansProxy();
		//beansHello();
		//beansGenericAnnotation();
		//beansAnnotationh();
		// beansDataSource();
		// beansAuto();
		// beansDao();
		// beansCar();
		// beansHelloWorld();
	}

}
