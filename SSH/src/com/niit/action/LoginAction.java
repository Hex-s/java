package com.niit.action;

import com.niit.dao.iface.IUserDao;
import com.niit.dao.impl.UserDao;
import com.niit.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	//由于UserDao被事务拦截器作用，因此当前Dao为代理对象
	private IUserDao userDao;
	private String userName;
	private String password;
	@Override
	public String execute() throws Exception {
		System.out.println(userName);
		System.out.println(password);
		User user = userDao.findUserByName(userName);
		if(user != null){
			if(user.getPassword().equals(password)){
				return SUCCESS;
			}
		}
		return ERROR;
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
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
}
