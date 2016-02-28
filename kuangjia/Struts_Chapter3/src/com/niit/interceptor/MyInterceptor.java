package com.niit.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	public void destroy() {
		System.out.println("拦截器被销毁");
	}

	public void init() {
		System.out.println("拦截器被创建");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("进入了拦截器A");
		//ActionInvocation封装了当前拦截的Action对象及ActionContext
		String actionName = invocation.getAction().getClass().getName();
		System.out.println("将要执行"+actionName);
		//invoke方法表示默认代理执行Action的execute方法
		String returnValue = invocation.invoke();
		System.out.println(actionName+"执行结束，返回结果："+returnValue);
		return returnValue;
	}

}
