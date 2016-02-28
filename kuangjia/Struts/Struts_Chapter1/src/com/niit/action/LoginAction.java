package com.niit.action;

import com.opensymphony.xwork2.Action;

/**
 * 处理登陆请求的业务模型
 * 在struts2中模型对象可以是任意的POJO类
 * struts2要求模型类至少要具备execute方法
 * @author Administrator
 *
 */
public class LoginAction{
	private String userName;
	private String password;
	/**
	 * 业务处理方法
	 * @return
	 */
	public String execute(){
		System.out.println("执行了登陆处理");
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
