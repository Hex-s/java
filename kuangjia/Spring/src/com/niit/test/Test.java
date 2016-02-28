package com.niit.test;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.niit.bean.Book;
import com.niit.bean.Computer;
import com.niit.bean.IBook;
import com.niit.bean.ITool;
import com.niit.bean.User;
import com.niit.bean.Ware;
import com.niit.dao.impl.WareDao;
import com.niit.proxy.DynaProxy;
import com.niit.proxy.ProxyUser;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		User user = new User();
//		user.setUserId(1001);
//		user.setUserName("tom");
//		Date date = new Date();
//		user.setBirthday(date);
		//创建bean读取器
		//XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//获取spring管理的bean对象
		//User user = (User)factory.getBean("user");
		//System.out.println(user.getUserName());
		//user.useTool();
		//System.out.println(user.getBirthday());
		
		//使用ApplicationContext获取spring管理的bean
		//ApplicationContext管理的bean默认情况是单例模式的
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		User user1 = (User)context.getBean("user");
//		User user2 = (User)context.getBean("user");
//		System.out.println(user1.hashCode());
//		System.out.println(user2.hashCode());
		
		/*****************静态代理*****************/
		//获取proxyUser
		//ProxyUser user = (ProxyUser)context.getBean("proxyUser");
		//user.useTool();
		
		/****************动态代理********************/
		//获取代理工厂
		DynaProxy factory = (DynaProxy)context.getBean("proxy");
//		//获取代理目标
//		Book target = (Book)context.getBean("book");
//		//动态获取代理类
//		IBook book = (IBook)factory.proxytarget(target);
//		book.bookInfo();
		
//		Computer target = (Computer)context.getBean("cpu");
//		ITool cpu = (ITool)factory.proxytarget(target);
//		//此时打印的是代理类的类型
//		System.out.println(cpu.getClass().getName());
//		cpu.toolInfo();
		
		/*****************spring自动代理****************/
//		User user = (User)context.getBean("user");
//		user.useTool();
		//配置过自动代理代理工厂，所有需要代理的bean对象返回的都是其代理类
//		IBook book = (IBook)context.getBean("book");
//		book.bookInfo();
		
		WareDao wareDao = (WareDao)context.getBean("wareDao");
		ArrayList<Ware> list = wareDao.findAll();
		for(Ware ware : list){
			System.out.println(ware.getWareName());
		}
	}

}
