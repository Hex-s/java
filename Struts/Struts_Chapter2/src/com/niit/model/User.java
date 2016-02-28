package com.niit.model;
/**
 * 登陆页面的表单模型
 * @author Administrator
 *
 */
public class User {
	//表单模型中的属性必须和表单元素的name一致
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
