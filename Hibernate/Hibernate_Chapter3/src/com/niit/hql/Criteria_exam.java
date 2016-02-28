package com.niit.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.niit.pojo.Student;

public class Criteria_exam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		//����Criteria����
		Criteria criteria = session.createCriteria(Student.class);
		//������ѯ��Ҫ��Ӳ�ѯ����
		//criteria.add(Restrictions.eq("stuId", 3));
		//����ѧ����6-7֮�䣬���Ҷ�Ӧ����ʦ����Ǵ��ڵ���2
		criteria.add(Restrictions.and(Restrictions.between("stuId", 6, 7), Restrictions.ge("teacher.teacherId", 2)));
		//ִ�в�ѯ
		List<Student> list = criteria.list();
		for(Student stu : list){
			System.out.println(stu.getStuName());
		}
	}

}
