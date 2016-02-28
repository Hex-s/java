package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * DAO�����࣬�ṩ��Hibernate session����Ļ�ȡ
 * @author Administrator
 *
 */
public class DaoUtil {
	private static SessionFactory factory;
	//ͨ����̬������Hibernate���
	static{
		Configuration config = new Configuration().configure();
		factory = config.buildSessionFactory();
	}
	/**
	 * ��ȡHibernate��session
	 * @return
	 */
	public synchronized static Session openSession(){
		return factory.openSession();
	}
}
