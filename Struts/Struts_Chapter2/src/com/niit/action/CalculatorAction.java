package com.niit.action;

import java.lang.reflect.Method;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ObjectFactory;

/**
 * 计算模型，当处理多个不同请求，并且提交的表单是同一个表单对象时，应尽量使用DMI（动态方法）解决
 * DMI不需要定义编写execute方法,需要重新定义其他方法,要求自定义方法必须返回String
 * @author Administrator
 *
 */
public class CalculatorAction extends ActionSupport {
	//表单元素
	private double num1;
	private double num2;
	
//	public void doFilter(){
//		Object action = ObjectFactory.getObjectFactory().buildAction(actionName, namespace, config, extraContext);
//		//通过对配置文件的解析解析获取Action是否存在method属性，则调用DMI方法，否则调用execute方法
//		Method method = action.getClass().getMethod("execute", null);
//		method.invoke(action, null);
//	}
	
	public String execute(){
		System.out.println("进入了execute方法");
		return SUCCESS;
	}
	
	public String addision(){
		System.out.println("进入了加法");
		return SUCCESS;
	}
	public String substraction(){
		System.out.println("进入了减法");
		return SUCCESS;
	}
	public String division(){
		System.out.println("进入了除法");
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
