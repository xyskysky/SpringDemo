package com.jwn.springdemo.helloworld;

public class Hello
{
	//�ֶ�
		private String user;
		
		public Hello() {
			System.out.println("HelloWorld's constructor...");
		}
		
		//JavaBean ʹ�� setter �� getter ����������
		public void setUserName(String user) {
			System.out.println("setUserName:" + user);
			this.user = user;
		}
		
		public void hello(){
			System.out.println("Hello:" + user);
		}
		
		public void init(){
			System.out.println("init method...");
		}
		
		public void destroy(){
			System.out.println("destroy method...");
		}
		
}
