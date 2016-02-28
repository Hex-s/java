package com.niit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.niit.pojo.Ware;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建Configuration加载配置文件
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		//创建会话工厂
		SessionFactory factory = config.buildSessionFactory();
		//使用会话工厂创建会话对象，并开启
		Session session = factory.openSession();
		System.out.println("已连接数据库");
		//创建并打开一个事务(如果执行的是数据查询，则不需要开启事务)
		Transaction transaction = session.beginTransaction();
		/****************数据对象的持久化操作****************/
		
		/**
		 * Hibernate操作数据时对象有3个状态
		 * 瞬时状态
		 * 持久状态
		 * 游离状态
		 */
		
		//创建商品对象
		//此时创建的ware对象和数据库没有关联，数据存储在内存中，当前状态为瞬时状态
//		Ware ware = new Ware();
//		ware.setId(4);
//		ware.setWareName("板擦");
//		ware.setPrice(3);
//		ware.setNum(20);
		//使用session保存对象
		//调用save,delete,update方法时，对象和数据库建立了联系，并且对象已经持久化保存在数据库中，当前状态为持久化状态
		//调用save,delete,update是用来将对象和数据库建立起关联，在事务没有提交前，该对象的状态都为持久状态
		//session.save(ware);
		
		
		
		//根据主键查询对象
		//get方法返回实体对象本身，load方法返回实体对象的代理类
		//get方法查找不到数据返回null,load方法查找不到数据抛出异常
		//get方法和load方法都会先在hibernate的一级缓存中查找数据，如果缓存中查找不到数据，get方法将直接至数据库进行检索，
		//而load方法将继续至二级缓存中检索数据，如果查找不到则再到数据库检索
		//load一般作为开发人员主观认为该对象已经存在于缓冲区域中进行的直接访问
		//get一般作为未知数据进行的检索
		Ware ware2 = (Ware)session.load(Ware.class, 1);	
		//由于war2引用自一级缓存中的数据，所以此时缓存中的价格被修改为5，数据库表中此时的价格还未被修改
		ware2.setPrice(5);
		//由于get方法先从一级缓存中查找数据，所以此时查到的数据是缓存中价格修改为5的数据，数据表中的数据此时也还未修改
		Ware ware = (Ware)session.get(Ware.class,1);
		System.out.println(ware.getClass().getName());
		System.out.println(ware.getWareName()+" "+ware.getPrice());
//		//修改数据
//		ware.setPrice(5);
//		session.update(ware);
//		//继续查询
//		ware = (Ware)session.load(Ware.class, 1);	
//		System.out.println(ware.getWareName()+" "+ware.getPrice());
		
		
//		Ware ware = (Ware)session.get(Ware.class, 1);	
//		System.out.println(ware.getClass().getName());
//		System.out.println(ware.getWareName()+" "+ware.getPrice());
//		//修改数据
//		ware.setPrice(5);
//		session.update(ware);
//		//继续查询
//		ware = (Ware)session.get(Ware.class, 1);	
//		System.out.println(ware.getWareName()+" "+ware.getPrice());
	
//		
//		ware.setNum(15);
//		ware.setPrice(5);
		//删除数据
//		session.delete(ware);
		
		//提交事务   真正实现持久化动作是通过事务提交来实现
		transaction.commit();
		//事务提交后对象状态为游离状态
//		ware.setPrice(20);
		//关闭会话
		session.close();
	}

}
