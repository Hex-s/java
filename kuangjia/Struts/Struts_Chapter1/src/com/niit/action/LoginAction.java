package com.niit.action;

import com.opensymphony.xwork2.Action;

/**
 * �����½�����ҵ��ģ��
 * ��struts2��ģ�Ͷ�������������POJO��
 * struts2Ҫ��ģ��������Ҫ�߱�execute����
 * @author Administrator
 *
 */
public class LoginAction{
	private String userName;
	private String password;
	/**
	 * ҵ������
	 * @return
	 */
	public String execute(){
		System.out.println("ִ���˵�½����");
		System.out.println(userName);
		System.out.println(password);
		if(userName.equals("admin")){
			return "success";
		}
		return "error";
	}
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
