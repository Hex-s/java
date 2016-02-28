package com.niit.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * ���Ʒ�����֪ͨ
 * @author Administrator
 *
 */
public class AroundAdvice implements MethodInterceptor {

	/**
	 * ����ִ�д�����Ľӿڷ���
	 * @return ����ִ�к�ķ���ֵ
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println(invocation.getMethod().getName()+"ִ��ǰ");
		//ִ�д�����
		Object value = invocation.proceed();
		System.out.println(invocation.getMethod().getName()+"ִ�к�");
		return value;
	}

}
