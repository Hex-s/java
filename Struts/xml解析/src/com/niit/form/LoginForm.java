package com.niit.form;

import org.apache.struts.action.ActionForm;

/**
 * ������  ��ܽ��Զ���������е����ݷ�װ���ö�����
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
		System.out.println("�����û���");
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
		System.out.println("��������");
		this.password = password;
	}
	private String password;
	
	
}
