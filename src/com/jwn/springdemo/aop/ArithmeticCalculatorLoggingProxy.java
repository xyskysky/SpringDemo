package com.jwn.springdemo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class ArithmeticCalculatorLoggingProxy
{
	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target)
	{
		super();
		this.target = target;
	}
	// 创建代理
	public ArithmeticCalculator getLoggingProxy()
	{

		ArithmeticCalculator proxy = null;

		ClassLoader loader = target.getClass().getClassLoader();
		Class<?>[] interfaces = new Class<?>[]{ArithmeticCalculator.class};

		InvocationHandler h = new InvocationHandler()
		{

			/* 
			 * proxy:代理的对象，一般不使用
			 * method:正在被调用的方法
			 * args：调用的方法的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable
			{
				String methodName=method.getName();
				List<Object> list = Arrays.asList(args);
				System.out.println("方法名称:"+methodName+"方法参数："+list);
				System.out.println("日志信息:"+methodName+"==============里面的日志");
				Object result = method.invoke(target, args);
				
				return result;
			}
		};
		// 生产代理
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,
				interfaces, h);
		return proxy;
	}

}
