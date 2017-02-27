package com.jwn.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService
{

	@Autowired
	private BookShopDao bookShopDao;

	//����ע��
	@Transactional
	public void purchase(String username, String isbn)
	{
		//��ȡ����
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		//���¿��
		bookShopDao.updateBookStock(isbn);
		//���½��
		bookShopDao.updateUserAccount(username, price);
	}

}
