package com.niit.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
/**
 * ����ִ�к��֪ͨ
 * @author Administrator
 *
 */
public class AfterAdvice implements AfterReturningAdvice {

	public void afterReturning(Object value, Method method, Object[] args,
			Object target) throws Throwable {
		System.out.println(target.getClass().getName()+"���"+method.getName()+"����ִ�н���������ֵ��"+value);
	}

}
