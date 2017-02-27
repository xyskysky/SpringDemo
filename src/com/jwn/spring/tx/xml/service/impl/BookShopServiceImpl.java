package com.jwn.spring.tx.xml.service.impl;

import com.jwn.spring.tx.xml.BookShopDao;
import com.jwn.spring.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService
{

	
    private BookShopDao bookShopDao;
    public void setBookShopDao(BookShopDao bookShopDao)
	{
		this.bookShopDao = bookShopDao;
	}
	@Override
	public void purchase(String username, String isbn)
	{
		
		// 获取单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		// 更新库存
		bookShopDao.updateBookStock(isbn);
		// 更新金额
		bookShopDao.updateUserAccount(username, price);
	}

}
