package com.niit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niit.pojo.Student;
import com.niit.pojo.Teacher;

public class ManyToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
	
		
		Teacher teacher = (Teacher)session.get(Teacher.class, 2);
		for(Student stu : teacher.getStuList()){
			System.out.println(stu.getStuName());
		}
		
//		Student stu = (Student)session.get(Student.class, 3);
//		//System.out.println(stu.getStuName());
//		//查询该学生对应的多个老师
//		for(Teacher teacher : stu.getTeacherSet()){
//			System.out.println(teacher.getTeacherName());
//		}
	}

}
