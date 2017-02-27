package com.jwn.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao
{

	@Autowired
	public JdbcTemplate jdbcTemplate;
	@Override
	public int findBookPriceByIsbn(String isbn)
	{
		String sql="SELECT price FROM book WHERE isbn=?";
		
		Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

	@Override
	public void updateBookStock(String isbn)
	{
		String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
		//»ñÈ¡ÏÖÔÚ¿â´æ
		int stock=jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if(stock==0)
		{
			throw new BookStockException("¿â´æ²»×ã!");
		}
		
		String sql = "UPDATE book_stock SET stock = stock -1 WHERE isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserAccount(String username, int price)
	{
		String sql = "SELECT balance FROM account WHERE username = ?";
		int blance=jdbcTemplate.queryForObject(sql, Integer.class, username);
		if(blance<price)
		{
			
			throw new UserAccountException("Óà¶î²»×ã£¡");
		}
		//ÐÞ¸ÄÕËºÅÓà¶î
		String sql2 = "UPDATE account SET balance = balance - ? WHERE username = ?";
		jdbcTemplate.update(sql2, price,username);
		
	}

}
