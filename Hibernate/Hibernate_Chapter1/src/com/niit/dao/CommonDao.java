package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ����DAO����װ��ʵ��������ɾ�Ĳ�4����������
 * @author Administrator
 *
 */
public class CommonDao<T> {
	public T findById(int id, Class<T> clazz){
		T t = null;
		Session session = DaoUtil.openSession();
		Object obj = session.get(clazz, id);
		session.close();
		if(obj != null){
			t = (T)obj;
		}
		return t;
	}
	public void add(T t){
		Session session = DaoUtil.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
	}
	public void update(T t){
		Session session = DaoUtil.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
	}
	public void delete(T t){
		Session session = DaoUtil.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
	}
}
