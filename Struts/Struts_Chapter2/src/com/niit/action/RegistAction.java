package com.niit.action;

import java.sql.Driver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.niit.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ͨ��ģ��������ȡ�����ݣ���Ҫʵ��ModelDriven�ӿ�
 * @author Administrator
 *
 */
public class RegistAction implements Action, ModelDriven<User> {
	
	private User user;
	
	public String execute() throws Exception {
		System.out.println("������registAction");
		
		//�쳣����
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
	 * ��ȡģ�Ͷ����ʵ��
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
