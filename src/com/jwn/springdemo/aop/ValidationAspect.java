package com.jwn.springdemo.aop;

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

@Order(1)
@Aspect
@Component
public class ValidationAspect
{
	
	@Pointcut("com.jwn.springdemo.aop.LoggingAspect.declareJoinPoint()")
	public void declareValidationPointcut()
	{
		
	}
	@Before("declareValidationPointcut()")
     public void beforeMethod(JoinPoint joinPoint)
     {
          String methodName=joinPoint.getSignature().getName();
          Object[] args = joinPoint.getArgs();
          System.out.println(">>validationAspect===beforeMethod==="+methodName+"===="+Arrays.asList(args));
     }
	@After("declareValidationPointcut()")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(">>validationAspect===afterMehtod==="+methodName+"===="+Arrays.asList(args));
	}
	@AfterReturning(value="declareValidationPointcut()",returning="obj")
	public void afterReturning(JoinPoint joinPoint,Object obj)
	{
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(">>validationAspect===afterReturning=="+methodName+"===="+Arrays.asList(args)+"====result:"+obj);
	}
	@AfterThrowing(value="declareValidationPointcut()",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex)
	{
		
		String methodName=joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(">>validationAspect===afterThrowing==="+methodName+"===="+Arrays.asList(args)+"====ex:"+ex.getMessage());
		
	}
}
