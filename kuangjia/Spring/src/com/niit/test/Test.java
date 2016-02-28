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
		//����bean��ȡ��
		//XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//��ȡspring�����bean����
		//User user = (User)factory.getBean("user");
		//System.out.println(user.getUserName());
		//user.useTool();
		//System.out.println(user.getBirthday());
		
		//ʹ��ApplicationContext��ȡspring�����bean
		//ApplicationContext�����beanĬ������ǵ���ģʽ��
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		User user1 = (User)context.getBean("user");
//		User user2 = (User)context.getBean("user");
//		System.out.println(user1.hashCode());
//		System.out.println(user2.hashCode());
		
		/*****************��̬����*****************/
		//��ȡproxyUser
		//ProxyUser user = (ProxyUser)context.getBean("proxyUser");
		//user.useTool();
		
		/****************��̬����********************/
		//��ȡ������
		DynaProxy factory = (DynaProxy)context.getBean("proxy");
//		//��ȡ����Ŀ��
//		Book target = (Book)context.getBean("book");
//		//��̬��ȡ������
//		IBook book = (IBook)factory.proxytarget(target);
//		book.bookInfo();
		
//		Computer target = (Computer)context.getBean("cpu");
//		ITool cpu = (ITool)factory.proxytarget(target);
//		//��ʱ��ӡ���Ǵ����������
//		System.out.println(cpu.getClass().getName());
//		cpu.toolInfo();
		
		/*****************spring�Զ�����****************/
//		User user = (User)context.getBean("user");
//		user.useTool();
		//���ù��Զ������������������Ҫ�����bean���󷵻صĶ����������
//		IBook book = (IBook)context.getBean("book");
//		book.bookInfo();
		
		WareDao wareDao = (WareDao)context.getBean("wareDao");
		ArrayList<Ware> list = wareDao.findAll();
		for(Ware ware : list){
			System.out.println(ware.getWareName());
		}
	}

}
