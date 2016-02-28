package com.niit.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class InitAction implements Action {
	private String userName;
	
	public String execute() throws Exception {
		//��struts��������д������
		ActionContext.getContext().put("userName", "jack");
		//��session��������
		ServletActionContext.getRequest().getSession().setAttribute("loginUser", "tony");
		return SUCCESS;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
