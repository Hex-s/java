package com.niit.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String userName;
	private String password;
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Ω¯»Î¡Àlogin action");
		System.out.println(userName);
		System.out.println(password);
		return SUCCESS;
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
