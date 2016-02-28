package com.niit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niit.pojo.Student;

public class ManyToOne {

	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		//��ѯѧ����Ϣ
		Student stu = (Student)session.get(Student.class, 1);
		
		System.out.println(stu.getStuName());
		
		//ͨ��many to one��ӳ�����ֱ����student�����л�ȡteacher�����е�����
		System.out.println(stu.getTeacher().getTeacherName());
		session.close();
		
	}
}
