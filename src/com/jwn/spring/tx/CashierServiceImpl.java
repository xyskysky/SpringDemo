package com.jwn.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashierService")
public class CashierServiceImpl implements CashierService
{

	@Autowired
	private BookShopService bookShopService;

	@Transactional
	public void checkout(String username, List<String> isbns)
	{
		for(String isbn:isbns)
		{
			bookShopService.purchase(username, isbn);
		}
	}

}
