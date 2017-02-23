package com.jwn.springdemo.aop;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator
{

	@Override
	public int add(int i, int j)
	{
		int result = i + j;
		return result;
	}

	@Override
	public int sub(int i, int j)
	{
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j)
	{
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j)
	{
		int result = i / j;
		return result;
	}

	@Override
	public void sum(int i, int j)
	{
		int result = (i + j) * 10;
		System.out.println("sum======reuslt====" + result);
	}

}
