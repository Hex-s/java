package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * DAO工具类，提供了Hibernate session对象的获取
 * @author Administrator
 *
 */
public class DaoUtil {
	private static SessionFactory factory;
	//通过静态块启动Hibernate框架
	static{
		Configuration config = new Configuration().configure();
		factory = config.buildSessionFactory();
	}
	/**
	 * 获取Hibernate的session
	 * @return
	 */
	public synchronized static Session openSession(){
		return factory.openSession();
	}
}
