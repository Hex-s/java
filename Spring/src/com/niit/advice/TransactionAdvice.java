package com.niit.advice;

import java.sql.Connection;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.niit.dao.util.CommonDao;

/**
 * ����֪ͨ
 * @author Administrator
 *
 */
public class TransactionAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Connection con = null;
		Object val = null;
		//���������ύ�ķ�ʽ
		//con.setAutoCommit(false);
		try {
			val = invocation.proceed();
			//��ȡ����Ŀ�꣨DAO������ʹ�õ�Connection
			con = ((CommonDao)invocation.getThis()).getCon();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//�ع�����
			con.rollback();
		}
		//�ύ����
		con.commit();
		return val;
		
	}

}
