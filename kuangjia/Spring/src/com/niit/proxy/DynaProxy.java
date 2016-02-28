package com.niit.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ������
 * @author Administrator
 *
 */
public class DynaProxy implements InvocationHandler {
	//����Ŀ��
	private Object target;
	/**
	 * ��̬ͨ������Ŀ��������̬������
	 * @param target
	 * @return
	 */
	public Object proxytarget(Object target){
		this.target = target;
		//���ض�̬������ķ��� 
		//��һ��������ʾ������Ŀ����������
		//�ڶ���������ʾ������Ŀ��ʵ�ֵĽӿ�ģ��
		//������������ʾ������̬������Ķ���
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	/**
	 * ��������Ҫִ�еĴ�����
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method.getName()+"����ִ��ǰ");
		//ִ�д���Ŀ���ԭ��������ȡ����ֵ
		Object val = method.invoke(target, args);
		System.out.println(method.getName()+"����ִ�к�");
		//���ط���ִ�к�Ľ��
		return val;
	}

}
