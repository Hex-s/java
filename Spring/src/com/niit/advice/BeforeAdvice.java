package com.niit.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 方法执行前通知（通知Advice又称为拦截器Interceptor）
 * @author Administrator
 *
 */
public class BeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target){
		System.out.println(target.getClass().getName()+"类的"+method.getName()+"方法将要被执行");
	}

}
