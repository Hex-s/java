package com.niit.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 在Action中实现数据校验必须继承ActionSupport类
 * @author Administrator
 *
 */
public class LoginAction extends ActionSupport{
	private String userName;
	private String password;
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入了login action");
		System.out.println(userName);
		System.out.println(password);
		return SUCCESS;
	}
	/**
	 * 验证方法
	 */
	@Override
	public void validate() {
		System.out.println("调用了验证方法");
		//System.out.println(userName);
		//System.out.println(password);
		//判断用户名是否有3位以上的字母数字下划线构成
		Pattern pattern = Pattern.compile("\\w{3,}");
		Matcher matcher = pattern.matcher(userName);
		if(!matcher.matches()){
			//添加错误信息
			addFieldError("nameError", "用户名格式不正确！");
		}
		//密码由4位数字构成
		pattern = pattern.compile("\\d{4}");
		matcher = pattern.matcher(password);
		if(!matcher.matches()){
			addFieldError("pwdError", "密码长度必须为6位！");
		}
		
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
