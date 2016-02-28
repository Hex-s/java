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
		//查询学生信息
		Student stu = (Student)session.get(Student.class, 1);
		
		System.out.println(stu.getStuName());
		
		//通过many to one的映射可以直接在student对象中获取teacher对象中的数据
		System.out.println(stu.getTeacher().getTeacherName());
		session.close();
		
	}
}
