package com.jwn.spring.tx.xml.service.impl;

import java.util.List;

import com.jwn.spring.tx.xml.service.BookShopService;
import com.jwn.spring.tx.xml.service.CashierService;

public class CashierServiceImpl implements CashierService
{

	private BookShopService bookShopService;
	public void setBookShopService(BookShopService bookShopService)
	{
		this.bookShopService = bookShopService;
	}
	@Override
	public void checkout(String username, List<String> isbns)
	{
		for(String isbn:isbns)
		{
			bookShopService.purchase(username, isbn);
		}
	}

}
