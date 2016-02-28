package com.niit.bean;

import java.util.Date;

public class User extends Parent {
	private int userId;
	private String userName;
	private Date birthday;
	private ITool tool;
	
	public User(){
		
	}
	public void init(){
		//System.out.println("user init");
	}
	public User(int userId, String userName){
		//System.out.println("user实例化");
		this.userId = userId;
		this.userName = userName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public ITool getTool() {
		return tool;
	}
	public void setTool(ITool tool) {
		this.tool = tool;
	}
	public void useTool(){
		//显示工具的信息
		tool.toolInfo();
	}
}
