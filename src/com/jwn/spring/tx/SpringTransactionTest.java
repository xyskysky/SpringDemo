package com.jwn.spring.tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest
{
	ApplicationContext ctx;
	BookShopDao bookShopDao;
	BookShopService bookShopService;
	CashierService cashierService;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		bookShopDao=ctx.getBean(BookShopDao.class);
		bookShopService=ctx.getBean(BookShopService.class);
		cashierService=ctx.getBean(CashierService.class);
	}
	
	@Test
	public void testTransactionlPropagation(){
	   cashierService.checkout("AA", Arrays.asList("1001","1002"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}
	@Test
	public void testBookShopDaoUpdateBookStock(){
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}

}
