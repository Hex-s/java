package com.niit.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��Action��ʵ������У�����̳�ActionSupport��
 * @author Administrator
 *
 */
public class LoginAction extends ActionSupport{
	private String userName;
	private String password;
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("������login action");
		System.out.println(userName);
		System.out.println(password);
		return SUCCESS;
	}
	/**
	 * ��֤����
	 */
	@Override
	public void validate() {
		System.out.println("��������֤����");
		//System.out.println(userName);
		//System.out.println(password);
		//�ж��û����Ƿ���3λ���ϵ���ĸ�����»��߹���
		Pattern pattern = Pattern.compile("\\w{3,}");
		Matcher matcher = pattern.matcher(userName);
		if(!matcher.matches()){
			//��Ӵ�����Ϣ
			addFieldError("nameError", "�û�����ʽ����ȷ��");
		}
		//������4λ���ֹ���
		pattern = pattern.compile("\\d{4}");
		matcher = pattern.matcher(password);
		if(!matcher.matches()){
			addFieldError("pwdError", "���볤�ȱ���Ϊ6λ��");
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
