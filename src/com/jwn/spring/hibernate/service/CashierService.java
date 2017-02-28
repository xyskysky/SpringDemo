package com.jwn.spring.hibernate.service;

import java.util.List;

public interface CashierService
{
	 void checkout(String username, List<String> isbns);
}
