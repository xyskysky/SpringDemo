package com.jwn.spring.hibernate.test;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jwn.spring.hibernate.service.BookShopService;
import com.jwn.spring.hibernate.service.CashierService;

public class SpringHibernateTest
{
	ApplicationContext ctx;
	BookShopService bookShopService;
	CashierService cashierService;

	{
		ctx=new ClassPathXmlApplicationContext("applicationContext-hibernate.xml");
		bookShopService=ctx.getBean(BookShopService.class);
		cashierService=ctx.getBean(CashierService.class);
	
	}
	@Test
	public void testDataSource() throws SQLException
	{
		DataSource dataSource=ctx.getBean(DataSource.class);
		
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testCashier(){
	  cashierService.checkout("AA", Arrays.asList("1001","1002"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}
}
