package com.jwn.spring.tx.xml;

public interface BookShopDao
{
	/**
	 * ������Ż�ȡ����
	 * 
	 * @param isn
	 * @return
	 */
	int findBookPriceByIsbn(String isbn);
	
	/**
	 * ������� ���¿��
	 * @param isbn
	 */
	void updateBookStock(String isbn);
	
	/**
	 * �����˺����
	 * @param username
	 * @param price
	 */
	void updateUserAccount(String username,int price);
}
