package com.niit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.niit.pojo.Student;
import com.niit.pojo.Teacher;

public class OneToMany {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		//查询第一个老师信息
		Teacher teacher = (Teacher)session.get(Teacher.class, 1);
		//System.out.println(teacher.getTeacherName());
		//遍历查找该老师所对应的所有学生
//		for(Student stu : teacher.getStuSet()){
//			System.out.print("学生姓名："+stu.getStuName()+",");
//			System.out.println("任课老师："+stu.getTeacher().getTeacherName());
//		}
		Student stu = (Student)session.get(Student.class, 3);
		//将查到的学生信息添加到老师信息中
		//teacher.getStuSet().add(stu);
		//teacher.getStuSet().remove(stu);
		//使用inverse将student表的控制权转移给student自身后只能由student对象才能对student表进行数据持久化操作
		//stu.setTeacher(null);
		
		//删除老师的信息，配置cascade后可以将学生表和老师表中满足条件的数据都一并删除
		session.delete(teacher);
		
		transaction.commit();
		session.close();
	}
}
