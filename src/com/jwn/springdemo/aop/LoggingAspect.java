package com.jwn.springdemo.aop;



import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect
{
	@Before("execution(* com.jwn.springdemo.aop.ArithmeticCalculator.*(..))")
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("beforeMethod========The method:"+methodName+"  "+Arrays.asList(args));
		
	}
	@After("execution(* com.jwn.springdemo.aop.*.*(..))")
	public void afterMethod(JoinPoint joinPoint)
	{
		
		System.out.println("afterMethod=====The method:"+joinPoint.getSignature().getName()+"----end");
	}
	
	
	
	
	
}
