package com.niit.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * ����ִ��ǰ֪ͨ��֪ͨAdvice�ֳ�Ϊ������Interceptor��
 * @author Administrator
 *
 */
public class BeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target){
		System.out.println(target.getClass().getName()+"���"+method.getName()+"������Ҫ��ִ��");
	}

}
