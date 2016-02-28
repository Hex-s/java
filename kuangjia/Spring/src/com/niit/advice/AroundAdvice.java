package com.niit.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * 环绕方法的通知
 * @author Administrator
 *
 */
public class AroundAdvice implements MethodInterceptor {

	/**
	 * 代理执行代理类的接口方法
	 * @return 方法执行后的返回值
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println(invocation.getMethod().getName()+"执行前");
		//执行代理方法
		Object value = invocation.proceed();
		System.out.println(invocation.getMethod().getName()+"执行后");
		return value;
	}

}
