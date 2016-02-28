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
		//创建Criteria对象
		Criteria criteria = session.createCriteria(Student.class);
		//条件查询需要添加查询规则
		//criteria.add(Restrictions.eq("stuId", 3));
		//查找学号在6-7之间，并且对应的老师编号是大于等于2
		criteria.add(Restrictions.and(Restrictions.between("stuId", 6, 7), Restrictions.ge("teacher.teacherId", 2)));
		//执行查询
		List<Student> list = criteria.list();
		for(Student stu : list){
			System.out.println(stu.getStuName());
		}
	}

}
