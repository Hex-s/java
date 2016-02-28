package com.niit.action;

import com.opensymphony.xwork2.Action;

public class LoginAction  implements Action{
	private String userName;
	private String password;
	private String[] hobby;
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

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(userName);
		System.out.println(password);
		for(String h : hobby){
			System.out.println(h);
		}
		return SUCCESS;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	
}
