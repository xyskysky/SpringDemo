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
		user.setUserName("Ҧ��");
		user.setWifeName("����Ҷ");
		List<Car> cars=new ArrayList<Car>();
		cars.add(new Car("��������", "��X65", 220, 100000));
		cars.add(new Car("����ͨ������", "����560", 200, 89000));
		user.setCars(cars);
		return user;
	}

	//����bean������
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
