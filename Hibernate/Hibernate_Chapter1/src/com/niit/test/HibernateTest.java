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
		//����Configuration���������ļ�
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		//�����Ự����
		SessionFactory factory = config.buildSessionFactory();
		//ʹ�ûỰ���������Ự���󣬲�����
		Session session = factory.openSession();
		System.out.println("���������ݿ�");
		//��������һ������(���ִ�е������ݲ�ѯ������Ҫ��������)
		Transaction transaction = session.beginTransaction();
		/****************���ݶ���ĳ־û�����****************/
		
		/**
		 * Hibernate��������ʱ������3��״̬
		 * ˲ʱ״̬
		 * �־�״̬
		 * ����״̬
		 */
		
		//������Ʒ����
		//��ʱ������ware��������ݿ�û�й��������ݴ洢���ڴ��У���ǰ״̬Ϊ˲ʱ״̬
//		Ware ware = new Ware();
//		ware.setId(4);
//		ware.setWareName("���");
//		ware.setPrice(3);
//		ware.setNum(20);
		//ʹ��session�������
		//����save,delete,update����ʱ����������ݿ⽨������ϵ�����Ҷ����Ѿ��־û����������ݿ��У���ǰ״̬Ϊ�־û�״̬
		//����save,delete,update����������������ݿ⽨���������������û���ύǰ���ö����״̬��Ϊ�־�״̬
		//session.save(ware);
		
		
		
		//����������ѯ����
		//get��������ʵ�������load��������ʵ�����Ĵ�����
		//get�������Ҳ������ݷ���null,load�������Ҳ��������׳��쳣
		//get������load������������hibernate��һ�������в������ݣ���������в��Ҳ������ݣ�get������ֱ�������ݿ���м�����
		//��load���������������������м������ݣ�������Ҳ������ٵ����ݿ����
		//loadһ����Ϊ������Ա������Ϊ�ö����Ѿ������ڻ��������н��е�ֱ�ӷ���
		//getһ����Ϊδ֪���ݽ��еļ���
		Ware ware2 = (Ware)session.load(Ware.class, 1);	
		//����war2������һ�������е����ݣ����Դ�ʱ�����еļ۸��޸�Ϊ5�����ݿ���д�ʱ�ļ۸�δ���޸�
		ware2.setPrice(5);
		//����get�����ȴ�һ�������в������ݣ����Դ�ʱ�鵽�������ǻ����м۸��޸�Ϊ5�����ݣ����ݱ��е����ݴ�ʱҲ��δ�޸�
		Ware ware = (Ware)session.get(Ware.class,1);
		System.out.println(ware.getClass().getName());
		System.out.println(ware.getWareName()+" "+ware.getPrice());
//		//�޸�����
//		ware.setPrice(5);
//		session.update(ware);
//		//������ѯ
//		ware = (Ware)session.load(Ware.class, 1);	
//		System.out.println(ware.getWareName()+" "+ware.getPrice());
		
		
//		Ware ware = (Ware)session.get(Ware.class, 1);	
//		System.out.println(ware.getClass().getName());
//		System.out.println(ware.getWareName()+" "+ware.getPrice());
//		//�޸�����
//		ware.setPrice(5);
//		session.update(ware);
//		//������ѯ
//		ware = (Ware)session.get(Ware.class, 1);	
//		System.out.println(ware.getWareName()+" "+ware.getPrice());
	
//		
//		ware.setNum(15);
//		ware.setPrice(5);
		//ɾ������
//		session.delete(ware);
		
		//�ύ����   ����ʵ�ֳ־û�������ͨ�������ύ��ʵ��
		transaction.commit();
		//�����ύ�����״̬Ϊ����״̬
//		ware.setPrice(20);
		//�رջỰ
		session.close();
	}

}
