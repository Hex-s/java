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
		//��ѯ��һ����ʦ��Ϣ
		Teacher teacher = (Teacher)session.get(Teacher.class, 1);
		//System.out.println(teacher.getTeacherName());
		//�������Ҹ���ʦ����Ӧ������ѧ��
//		for(Student stu : teacher.getStuSet()){
//			System.out.print("ѧ��������"+stu.getStuName()+",");
//			System.out.println("�ο���ʦ��"+stu.getTeacher().getTeacherName());
//		}
		Student stu = (Student)session.get(Student.class, 3);
		//���鵽��ѧ����Ϣ��ӵ���ʦ��Ϣ��
		//teacher.getStuSet().add(stu);
		//teacher.getStuSet().remove(stu);
		//ʹ��inverse��student��Ŀ���Ȩת�Ƹ�student�����ֻ����student������ܶ�student��������ݳ־û�����
		//stu.setTeacher(null);
		
		//ɾ����ʦ����Ϣ������cascade����Խ�ѧ�������ʦ�����������������ݶ�һ��ɾ��
		session.delete(teacher);
		
		transaction.commit();
		session.close();
	}
}
