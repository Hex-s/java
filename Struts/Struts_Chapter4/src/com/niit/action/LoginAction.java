package com.niit.action;

import java.text.MessageFormat;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		//��ȡ��Դ�ļ�����Ϣ
		//String name = getText("name");
		//��ȡ��Դ�ļ���Ϣ��ͬʱע�����
		String name = getText("name",Arrays.asList("A","B"));
		System.out.println(name);
		//ע��ռλ���Ĳ���
		//name = MessageFormat.format(name, "tom","jack");
		
		//System.out.println(name);
		return SUCCESS;
	}
	
}
