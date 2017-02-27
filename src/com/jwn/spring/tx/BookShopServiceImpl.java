package com.jwn.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService
{

	@Autowired
	private BookShopDao bookShopDao;

	//事务注解
	@Transactional
	public void purchase(String username, String isbn)
	{
		//获取单价
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		//更新库存
		bookShopDao.updateBookStock(isbn);
		//更新金额
		bookShopDao.updateUserAccount(username, price);
	}

}
