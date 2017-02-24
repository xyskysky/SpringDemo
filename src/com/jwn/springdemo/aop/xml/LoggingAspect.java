package com.jwn.springdemo.aop.xml;



import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class LoggingAspect
{
	//前置方法
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("beforeMethod===="+methodName+"====="+Arrays.asList(args));
	}
	
	//后置方法
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("afterMethod===="+methodName+"====="+Arrays.asList(args));
	}
	//返回通知 可以访问方法的返回值
	public void afterReturning(JoinPoint joinPoint,Object obj)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		System.out.println("afterReturning===="+methodName+"======="+Arrays.asList(args)+"=======resut:"+obj);
	}

    public void afterThrowing(JoinPoint joinPoint,Exception ex)
    {
    	String methodName=joinPoint.getSignature().getName();
    	Object[] args = joinPoint.getArgs();
    	System.out.println("afterThrowing====="+methodName+"======"+Arrays.asList(args)+"==========ex:"+ex);
    }
   
    /**
	 * 环绕通知需要携带 ProceedingJoinPoint 类型的参数. 
	 * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
	 * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
	 */

 
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint)
    {
    	String methodName = proceedingJoinPoint.getSignature().getName();
    	Object[] args = proceedingJoinPoint.getArgs();
    	System.out.println("aroundMethod======="+methodName+"========"+Arrays.asList(args));
    	Object result=null;
    	try
		{
    		System.out.println("前置通知======"+methodName+"======"+Arrays.asList(args));
			result=proceedingJoinPoint.proceed();
			System.out.println("返回通知======"+methodName+"======"+Arrays.asList(args)+"=======result:"+result);
		}
		catch (Throwable e)
		{
			
			e.printStackTrace();
			System.out.println("异常通知======="+methodName+"======"+Arrays.asList(args)+" ex:"+e.getMessage());
		}
    	System.out.println("后置通知======="+methodName+"======="+Arrays.asList(args));
    	return result;
    }
}
