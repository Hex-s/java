package com.niit.action;

import com.opensymphony.xwork2.Action;

public class RegistAction implements Action {
	private String userName;
	private String password;
	private String confirmPassword;
	private int age;
	private String email;
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("������regist action");
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
