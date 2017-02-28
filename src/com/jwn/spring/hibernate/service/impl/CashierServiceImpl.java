package com.jwn.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwn.spring.hibernate.service.BookShopService;
import com.jwn.spring.hibernate.service.CashierService;

@Service
public class CashierServiceImpl implements CashierService
{

	@Autowired
	private BookShopService bookShopService;
	@Override
	public void checkout(String username, List<String> isbns)
	{
		for(String isbn:isbns)
		{
			bookShopService.purchase(username, isbn);
		}
	}

}
