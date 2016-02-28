package com.niit.action;

import java.text.MessageFormat;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		//获取资源文件的信息
		//String name = getText("name");
		//获取资源文件信息的同时注入参数
		String name = getText("name",Arrays.asList("A","B"));
		System.out.println(name);
		//注入占位符的参数
		//name = MessageFormat.format(name, "tom","jack");
		
		//System.out.println(name);
		return SUCCESS;
	}
	
}
