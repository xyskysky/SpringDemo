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
	//ǰ�÷���
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("beforeMethod===="+methodName+"====="+Arrays.asList(args));
	}
	
	//���÷���
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("afterMethod===="+methodName+"====="+Arrays.asList(args));
	}
	//����֪ͨ ���Է��ʷ����ķ���ֵ
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
	 * ����֪ͨ��ҪЯ�� ProceedingJoinPoint ���͵Ĳ���. 
	 * ����֪ͨ�����ڶ�̬�����ȫ����: ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��.
	 * �һ���֪ͨ�����з���ֵ, ����ֵ��ΪĿ�귽���ķ���ֵ
	 */

 
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint)
    {
    	String methodName = proceedingJoinPoint.getSignature().getName();
    	Object[] args = proceedingJoinPoint.getArgs();
    	System.out.println("aroundMethod======="+methodName+"========"+Arrays.asList(args));
    	Object result=null;
    	try
		{
    		System.out.println("ǰ��֪ͨ======"+methodName+"======"+Arrays.asList(args));
			result=proceedingJoinPoint.proceed();
			System.out.println("����֪ͨ======"+methodName+"======"+Arrays.asList(args)+"=======result:"+result);
		}
		catch (Throwable e)
		{
			
			e.printStackTrace();
			System.out.println("�쳣֪ͨ======="+methodName+"======"+Arrays.asList(args)+" ex:"+e.getMessage());
		}
    	System.out.println("����֪ͨ======="+methodName+"======="+Arrays.asList(args));
    	return result;
    }
}
