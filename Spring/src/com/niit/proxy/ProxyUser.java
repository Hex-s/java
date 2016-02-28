package com.niit.proxy;

import com.niit.bean.User;

/**
 * 静态代理类
 * @author Administrator
 *
 */
public class ProxyUser {
	//代理目标
	private User user;
	
	public ProxyUser(User user){
		this.user = user;
	}
	public void useTool(){
		//代码扩展处
		System.out.println("useTool方法执行前");
		user.useTool();
		//代码扩展处
		System.out.println("useTool方法执行后");
	}
}
