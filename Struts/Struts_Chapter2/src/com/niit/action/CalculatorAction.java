package com.niit.action;

import java.lang.reflect.Method;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ObjectFactory;

/**
 * ����ģ�ͣ�����������ͬ���󣬲����ύ�ı���ͬһ��������ʱ��Ӧ����ʹ��DMI����̬���������
 * DMI����Ҫ�����дexecute����,��Ҫ���¶�����������,Ҫ���Զ��巽�����뷵��String
 * @author Administrator
 *
 */
public class CalculatorAction extends ActionSupport {
	//��Ԫ��
	private double num1;
	private double num2;
	
//	public void doFilter(){
//		Object action = ObjectFactory.getObjectFactory().buildAction(actionName, namespace, config, extraContext);
//		//ͨ���������ļ��Ľ���������ȡAction�Ƿ����method���ԣ������DMI�������������execute����
//		Method method = action.getClass().getMethod("execute", null);
//		method.invoke(action, null);
//	}
	
	public String execute(){
		System.out.println("������execute����");
		return SUCCESS;
	}
	
	public String addision(){
		System.out.println("�����˼ӷ�");
		return SUCCESS;
	}
	public String substraction(){
		System.out.println("�����˼���");
		return SUCCESS;
	}
	public String division(){
		System.out.println("�����˳���");
		return SUCCESS;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}
	
}
