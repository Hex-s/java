package com.niit.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
/**
 * 方法执行后的通知
 * @author Administrator
 *
 */
public class AfterAdvice implements AfterReturningAdvice {

	public void afterReturning(Object value, Method method, Object[] args,
			Object target) throws Throwable {
		System.out.println(target.getClass().getName()+"类的"+method.getName()+"方法执行结束，返回值是"+value);
	}

}
