package com.niit.advice;

import java.sql.Connection;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.niit.dao.util.CommonDao;

/**
 * 事务通知
 * @author Administrator
 *
 */
public class TransactionAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Connection con = null;
		Object val = null;
		//设置事务提交的方式
		//con.setAutoCommit(false);
		try {
			val = invocation.proceed();
			//获取代理目标（DAO对象）中使用的Connection
			con = ((CommonDao)invocation.getThis()).getCon();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//回滚事务
			con.rollback();
		}
		//提交事务
		con.commit();
		return val;
		
	}

}
