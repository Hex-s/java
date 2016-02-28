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
		
		/**********************��ѯ��������***********************/
		//����HQL���
		//HQL����д���������ݶ���Java�е�ʵ����������
		//HQLʹ���������ķ�ʽ��������漰���Ķ���ת����SQL�ٽ���JDBCִ��
		//��ѯ���е�ѧ����Ϣ
		//String hql = "select stu from Student as stu";
//		String hql = "from Student";
//		//����Query����
//		Query query = session.createQuery(hql);
//		//ִ�в�ѯ
//		List<Student> list = query.list();
//		//�������
//		for(Student stu : list){
//			System.out.println(stu.getStuName());
//		}
		
		/******************������ѯ********************/
		//��ѯѧ����6�ŵ�ѧ����Ϣ
		//String hql = "from Student where stuId = 6";
		//��ѯѧ����6��20֮�������ѧ����Ϣ
		//String hql = "from Student where stuId between 6 and 20";
		//String hql = "from Student as stu where stu.stuId between 6 and 20";
		//��ѯû����д��teacherId��ѧ��
//		String hql = "from Student where teacher.teacherId is null";
//		Query query = session.createQuery(hql);
//		List<Student> list = query.list();
//		for(Student stu : list){
//			System.out.println(stu.getStuName());
//		}
		
		/*****************ָ���в�ѯ********************/
		//��ѯѧ����6��ͬѧ�Ŀ���
//		String hql = "select cardNo from Card where stu.stuId=6";
//		Query query = session.createQuery(hql);
//		List<String> list = query.list();
//		for(String cardNo : list){
//			System.out.println(cardNo);
//		}
		//��ѯ������stuA����ʦ���
//		String hql = "select teacher.teacherId from Student where stuName='stuA'";
//		Query query = session.createQuery(hql);
//		List<Integer> list = query.list();
//		for(Integer teacherId : list){
//			System.out.println(teacherId);
//		}
		//��ѯѧ����6��ͬѧ�Ŀ��źͱ��
//		String hql = "select cardNo,cardId from Card where stuId=6";
//		Query query = session.createQuery(hql);
//		//���в�ѯ����Object[]����
//		List<Object[]> list = query.list();
//		for(Object[] array : list){
//			System.out.println(array[0]+","+array[1]);
//		}
//		//ʹ�õ�������ѯ����
//		Iterator<Object[]> ite = query.iterate();
//		while(ite.hasNext()){
//			Object[] array = ite.next();
//			System.out.println(array[0]+","+array[1]);
//		}
		
		/******************HQL���ע�����****************/
		//��ѯѧ����6��ѧ����Ϣ
//		int stuId = 6;
		//ʹ��?ռλ��ע��
//		String hql = "from Student where stuId=?";
//		Query query = session.createQuery(hql);
//		//ʹ��query����ע�����
//		//Hibernate�в�����������0��ʼ
//		query.setInteger(0, stuId);
		//:������ע��
//		String hql = "from Student where stuId=:id";
//		Query query = session.createQuery(hql);
//		//ע�����
//		query.setInteger("id", stuId);
//		//��ѯ
//		List<Student> list = query.list();
//		for(Student stu : list){
//			System.out.println(stu.getStuName());
//		}
		
		/**************��ѯ���е��е�����***************/
		//��ѯѧ��������
//		String hql = "select count(*) from Student";
//		Query query = session.createQuery(hql);
//		//���������ǵ��е���
//		Object count = query.uniqueResult();
//		System.out.println("����"+count+"��ѧ��");
		
		/******************���򣬷��飬�Ӳ�ѯ******************/
		//��ѧ�Ž�������
//		String hql = "from Student order by stuId asc";
//		Query query = session.createQuery(hql);
//		List<Student> list = query.list();
//		for(Student stu : list){
//			System.out.println(stu.getStuName());
//		}
		//��ѯѧ������������ÿ����ʦ�̵�ѧ������
//		String hql = "select count(*) from Student where teacher.teacherId is not null group by teacher.teacherId";
//		Query query = session.createQuery(hql);
//		List<Long> list = query.list();
//		for(Long count : list){
//			System.out.println(count);
//		}
		//��ѯ����ΪstuA��ѧ���Ŀ���
		//HQL֧���Ӳ�ѯ
		//String hql = "select cardNo from Card where stu.stuId = (select stuId from Student where stuName = 'stuA')";
		//����ʹ��ӳ���������дHQL
//		String hql = "select card.cardNo from Student where stuName = 'stuA'";
//		Query query = session.createQuery(hql);
//		List<String> list = query.list();
//		for(String cardNo : list){
//			System.out.println(cardNo);
//		}
		
		/*******************��ҳ********************/
		//������Ҫ��ҳ�����HQL���
		String hql = "from Student";
		//���õ�ǰ��ҳ��
		int page = 1;
		//����ÿҳ������
		int pageSize = 2;
		Query query = session.createQuery(hql);
		//����ÿҳ������
		query.setMaxResults(pageSize);
		//���õ�ǰҳ����ʼ����
		query.setFirstResult((page-1)*pageSize);
		
		List<Student> list = query.list();
		for(Student stu : list){
			System.out.println(stu.getStuName());
		}
		session.close();
	}

}
