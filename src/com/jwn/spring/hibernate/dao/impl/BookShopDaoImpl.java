package com.jwn.spring.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwn.spring.hibernate.dao.BookShopDao;
import com.jwn.spring.hibernate.exception.BookStockException;
import com.jwn.spring.hibernate.exception.UserAccountException;

@Repository
public class BookShopDaoImpl implements BookShopDao
{

	@Autowired
	private SessionFactory sessionFactory;

	// ���Ƽ�ʹ�� HibernateTemplate �� HibernateDaoSupport
	// ��Ϊ�����ᵼ�� Dao �� Spring �� API �������
	// ������ֲ�Ա��
	// private HibernateTemplate hibernateTemplate;

	// ��ȡ�͵�ǰ�̰߳󶨵� Session.
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int findBookPriceByIsbn(String isbn)
	{
		String hql="SELECT b.price FROM Book b WHERE b.isbn = ?";
		return (int) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn)
	{
		//���¿�� �жϿ���Ƿ���
		String hql1="SELECT b.stock FROM Book b WHERE b.isbn=?";
		int stock=(int) getSession().createQuery(hql1).setString(0, isbn).uniqueResult();
		if(stock==0)
		{
			throw new BookStockException("��治��!");
		}
		String hql2="update Book b set b.stock=b.stock-1 where b.isbn=? ";
		getSession().createQuery(hql2).setString(0, isbn).executeUpdate();
	}
	@Override
	public void updateUserAccount(String username, int price)
	{
		String hql1="select a.balance from Account a where a.username=?";
		int blance=(int) getSession().createQuery(hql1).setString(0, username).uniqueResult();
		if(blance<price)
		{
			throw new UserAccountException("����!");
		}
		String hql2="update Account a set a.balance=a.balance-? where a.username=? ";
		getSession().createQuery(hql2).setInteger(0, price).setString(1, username).executeUpdate();
	}

}
