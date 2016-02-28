package com.niit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.dao.impl.UserDao;
import com.niit.pojo.User;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
//		SessionFactory factory = (SessionFactory)ctx.getBean("sessionFactory");
//		Session session = factory.openSession();
//		User user = (User)session.get(User.class, 1);
//		System.out.println(user.getUserName());
		
		UserDao dao = (UserDao)ctx.getBean("userDao");
		User user = dao.findUserByName("tom");
		if(user != null){
			System.out.println(user.getPassword());
		}
	}

}
