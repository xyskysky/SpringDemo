package com.jwn.springdemo.helloworld;

public class HelloWorld
{
	private String user;
	private int number;
	
    public HelloWorld()
    {
    	System.out.println("���캯�����á�������");
    }
    //���캯��
    public HelloWorld(String user,int number)
    {
    	this.user=user;
    	this.number=number;
    }
   
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		System.out.println("setUser.....");
		this.user = user;
	}
	@Override
	public String toString()
	{
		return "HelloWorld [user=" + user + ", number=" + number + "]";
	}

	
    
}
