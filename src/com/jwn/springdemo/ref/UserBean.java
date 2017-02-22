package com.jwn.springdemo.ref;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;

import com.jwn.springdemo.helloworld.Car;
import com.jwn.springdemo.helloworld.User;

public class UserBean implements FactoryBean<User>
{

	@Override
	public User getObject() throws Exception
	{
		User user=new User();
		user.setUserName("姚明");
		user.setWifeName("朱丽叶");
		List<Car> cars=new ArrayList<Car>();
		cars.add(new Car("北京汽车", "绅宝X65", 220, 100000));
		cars.add(new Car("上汽通用五菱", "宝骏560", 200, 89000));
		user.setCars(cars);
		return user;
	}

	//返回bean的类型
	@Override
	public Class<?> getObjectType()
	{
		return User.class;
	}

	@Override
	public boolean isSingleton()
	{
		return false;
	}

}
