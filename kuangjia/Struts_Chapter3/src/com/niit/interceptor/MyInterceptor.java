package com.niit.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	public void destroy() {
		System.out.println("������������");
	}

	public void init() {
		System.out.println("������������");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("������������A");
		//ActionInvocation��װ�˵�ǰ���ص�Action����ActionContext
		String actionName = invocation.getAction().getClass().getName();
		System.out.println("��Ҫִ��"+actionName);
		//invoke������ʾĬ�ϴ���ִ��Action��execute����
		String returnValue = invocation.invoke();
		System.out.println(actionName+"ִ�н��������ؽ����"+returnValue);
		return returnValue;
	}

}
