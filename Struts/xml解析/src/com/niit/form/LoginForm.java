package com.niit.form;

import org.apache.struts.action.ActionForm;

/**
 * 表单对象  框架将自动将请求表单中的数据封装至该对象中
 * @author Administrator
 *
 */
public class LoginForm extends ActionForm
{
	private String userName;
	/**
	 * @return the userName
	 */
	public String getUserName()
	{
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName)
	{
		System.out.println("设置用户名");
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		System.out.println("设置密码");
		this.password = password;
	}
	private String password;
	
	
}
