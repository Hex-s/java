package com.niit.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niit.pojo.Card;
import com.niit.pojo.Student;

public class HQL_exam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		/**********************查询所有数据***********************/
		//定义HQL语句
		//HQL语句编写的所有内容都是Java中的实体对象和属性
		//HQL使用面向对象的方式将语句中涉及到的对象转换成SQL再交给JDBC执行
		//查询所有的学生信息
		//String hql = "select stu from Student as stu";
//		String hql = "from Student";
//		//创建Query对象
//		Query query = session.createQuery(hql);
//		//执行查询
//		List<Student> list = query.list();
//		//遍历结果
//		for(Student stu : list){
//			System.out.println(stu.getStuName());
//		}
		
		/******************条件查询********************/
		//查询学号是6号的学生信息
		//String hql = "from Student where stuId = 6";
		//查询学号在6到20之间的所有学生信息
		//String hql = "from Student where stuId between 6 and 20";
		//String hql = "from Student as stu where stu.stuId between 6 and 20";
		//查询没有填写过teacherId的学生
//		String hql = "from Student where teacher.teacherId is null";
//		Query query = session.createQuery(hql);
//		List<Student> list = query.list();
//		for(Student stu : list){
//			System.out.println(stu.getStuName());
//		}
		
		/*****************指定列查询********************/
		//查询学号是6号同学的卡号
//		String hql = "select cardNo from Card where stu.stuId=6";
//		Query query = session.createQuery(hql);
//		List<String> list = query.list();
//		for(String cardNo : list){
//			System.out.println(cardNo);
//		}
		//查询姓名是stuA的老师编号
//		String hql = "select teacher.teacherId from Student where stuName='stuA'";
//		Query query = session.createQuery(hql);
//		List<Integer> list = query.list();
//		for(Integer teacherId : list){
//			System.out.println(teacherId);
//		}
		//查询学号是6号同学的卡号和编号
//		String hql = "select cardNo,cardId from Card where stuId=6";
//		Query query = session.createQuery(hql);
//		//多列查询返回Object[]类型
//		List<Object[]> list = query.list();
//		for(Object[] array : list){
//			System.out.println(array[0]+","+array[1]);
//		}
//		//使用迭代器查询数据
//		Iterator<Object[]> ite = query.iterate();
//		while(ite.hasNext()){
//			Object[] array = ite.next();
//			System.out.println(array[0]+","+array[1]);
//		}
		
		/******************HQL语句注入参数****************/
		//查询学号是6的学生信息
//		int stuId = 6;
		//使用?占位符注入
//		String hql = "from Student where stuId=?";
//		Query query = session.createQuery(hql);
//		//使用query对象注入参数
//		//Hibernate中参数的索引从0开始
//		query.setInteger(0, stuId);
		//:变量名注入
//		String hql = "from Student where stuId=:id";
//		Query query = session.createQuery(hql);
//		//注入参数
//		query.setInteger("id", stuId);
//		//查询
//		List<Student> list = query.list();
//		for(Student stu : list){
//			System.out.println(stu.getStuName());
//		}
		
		/**************查询单行单列的数据***************/
		//查询学生的数量
//		String hql = "select count(*) from Student";
//		Query query = session.createQuery(hql);
//		//如果结果集是单行单列
//		Object count = query.uniqueResult();
//		System.out.println("共有"+count+"个学生");
		
		/******************排序，分组，子查询******************/
		//对学号进行排序
//		String hql = "from Student order by stuId asc";
//		Query query = session.createQuery(hql);
//		List<Student> list = query.list();
//		for(Student stu : list){
//			System.out.println(stu.getStuName());
//		}
		//查询学生表中描述的每个老师教的学生数量
//		String hql = "select count(*) from Student where teacher.teacherId is not null group by teacher.teacherId";
//		Query query = session.createQuery(hql);
//		List<Long> list = query.list();
//		for(Long count : list){
//			System.out.println(count);
//		}
		//查询姓名为stuA的学生的卡号
		//HQL支持子查询
		//String hql = "select cardNo from Card where stu.stuId = (select stuId from Student where stuName = 'stuA')";
		//尽量使用映射对象来编写HQL
//		String hql = "select card.cardNo from Student where stuName = 'stuA'";
//		Query query = session.createQuery(hql);
//		List<String> list = query.list();
//		for(String cardNo : list){
//			System.out.println(cardNo);
//		}
		
		/*******************分页********************/
		//定义需要分页结果的HQL语句
		String hql = "from Student";
		//设置当前的页数
		int page = 1;
		//设置每页的条数
		int pageSize = 2;
		Query query = session.createQuery(hql);
		//设置每页的条数
		query.setMaxResults(pageSize);
		//设置当前页的起始索引
		query.setFirstResult((page-1)*pageSize);
		
		List<Student> list = query.list();
		for(Student stu : list){
			System.out.println(stu.getStuName());
		}
		session.close();
	}

}
