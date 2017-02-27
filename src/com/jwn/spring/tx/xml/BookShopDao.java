package com.jwn.spring.tx.xml;

public interface BookShopDao
{
	/**
	 * 根据书号获取单价
	 * 
	 * @param isn
	 * @return
	 */
	int findBookPriceByIsbn(String isbn);
	
	/**
	 * 根据书号 更新库存
	 * @param isbn
	 */
	void updateBookStock(String isbn);
	
	/**
	 * 更新账号余额
	 * @param username
	 * @param price
	 */
	void updateUserAccount(String username,int price);
}
