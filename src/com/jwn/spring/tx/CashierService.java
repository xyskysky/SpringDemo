package com.jwn.spring.tx;

import java.util.List;

public interface CashierService
{
	void checkout(String username, List<String> isbns);
}
