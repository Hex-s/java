package com.niit.proxy;

import com.niit.bean.User;

/**
 * ��̬������
 * @author Administrator
 *
 */
public class ProxyUser {
	//����Ŀ��
	private User user;
	
	public ProxyUser(User user){
		this.user = user;
	}
	public void useTool(){
		//������չ��
		System.out.println("useTool����ִ��ǰ");
		user.useTool();
		//������չ��
		System.out.println("useTool����ִ�к�");
	}
}
