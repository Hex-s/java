package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * ����DAO���󣬷�װ����ɾ��ĵĻ�������
 * @author Administrator
 *
 */
public class CommonDao<T> extends HibernateDaoSupport {
	public void save(T t){
		getHibernateTemplate().save(t);
	}
	public T find(int id,Class<T> clazz){
		return getHibernateTemplate().get(clazz, id);
	}
	public void updae(T t){
		getHibernateTemplate().update(t);
	}
	public void delete(T t){
		getHibernateTemplate().delete(t);
	}
	public List<T> findByHql(String hql,Object[] parmas){
		List<T> list = new ArrayList<T>();
		//��ȡsession
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		//ע�����
		if(parmas != null){
			for(int i = 0; i < parmas.length; i++){
				query.setParameter(i, parmas[i]);
			}
		}
		list = query.list();
		return list;
	}
}
