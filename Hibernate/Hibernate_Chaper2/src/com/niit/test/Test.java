package com.niit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.niit.pojo.Teacher;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		Teacher teaher = new Teacher();
		teaher.setTeacherName("teacherC");
		//新增
		session.save(teaher);
		//提交事务
		transaction.commit();
		session.close();
	}

}
