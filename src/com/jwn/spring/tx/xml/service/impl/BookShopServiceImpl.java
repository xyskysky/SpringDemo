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
		
		// ��ȡ����
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		// ���¿��
		bookShopDao.updateBookStock(isbn);
		// ���½��
		bookShopDao.updateUserAccount(username, price);
	}

}
