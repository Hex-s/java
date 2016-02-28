package com.niit.action;

import java.sql.Driver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.niit.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 通过模型驱动获取表单数据，需要实现ModelDriven接口
 * @author Administrator
 *
 */
public class RegistAction implements Action, ModelDriven<User> {
	
	private User user;
	
	public String execute() throws Exception {
		System.out.println("进入了registAction");
		
		//异常代码
		int age = Integer.parseInt(user.getUserName());
		
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getParameter("userName"));
		if(!user.getUserName().equals("admin")){
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 获取模型对象的实例
	 */
	public User getModel() {
		user = new User();
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
