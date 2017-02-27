package com.jwn.spring.tx.xml.service;

import java.util.List;

public interface CashierService
{
	void checkout(String username, List<String> isbns);
}
