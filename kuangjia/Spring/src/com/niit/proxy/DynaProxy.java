package com.niit.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 * @author Administrator
 *
 */
public class DynaProxy implements InvocationHandler {
	//代理目标
	private Object target;
	/**
	 * 动态通过代理目标生产动态代理类
	 * @param target
	 * @return
	 */
	public Object proxytarget(Object target){
		this.target = target;
		//返回动态代理类的方法 
		//第一个参数表示被代理目标的类加载器
		//第二个参数表示被代理目标实现的接口模板
		//第三个参数表示生产动态代理类的对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	/**
	 * 代理类所要执行的代理方法
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method.getName()+"方法执行前");
		//执行代理目标的原方法并获取返回值
		Object val = method.invoke(target, args);
		System.out.println(method.getName()+"方法执行后");
		//返回方法执行后的结果
		return val;
	}

}
