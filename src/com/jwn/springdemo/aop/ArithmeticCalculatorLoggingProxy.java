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
	// ��������
	public ArithmeticCalculator getLoggingProxy()
	{

		ArithmeticCalculator proxy = null;

		ClassLoader loader = target.getClass().getClassLoader();
		Class<?>[] interfaces = new Class<?>[]{ArithmeticCalculator.class};

		InvocationHandler h = new InvocationHandler()
		{

			/* 
			 * proxy:����Ķ���һ�㲻ʹ��
			 * method:���ڱ����õķ���
			 * args�����õķ����Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable
			{
				String methodName=method.getName();
				List<Object> list = Arrays.asList(args);
				System.out.println("��������:"+methodName+"����������"+list);
				System.out.println("��־��Ϣ:"+methodName+"==============�������־");
				Object result = method.invoke(target, args);
				
				return result;
			}
		};
		// ��������
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,
				interfaces, h);
		return proxy;
	}

}
