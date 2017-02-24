package com.jwn.springdemo.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


public class ValidationAspect
{

     public void beforeMethod(JoinPoint joinPoint)
     {
          String methodName=joinPoint.getSignature().getName();
          Object[] args = joinPoint.getArgs();
          System.out.println(">>validationAspect===beforeMethod==="+methodName+"===="+Arrays.asList(args));
     }
	
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(">>validationAspect===afterMehtod==="+methodName+"===="+Arrays.asList(args));
	}

	public void afterReturning(JoinPoint joinPoint,Object obj)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(">>validationAspect===afterReturning=="+methodName+"===="+Arrays.asList(args)+"====result:"+obj);
	}
	
	public void afterThrowing(JoinPoint joinPoint,Exception ex)
	{
		
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(">>validationAspect===afterThrowing==="+methodName+"===="+Arrays.asList(args)+"====ex:"+ex.getMessage());
		
	}
}
