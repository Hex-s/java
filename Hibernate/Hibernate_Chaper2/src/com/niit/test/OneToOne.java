package com.niit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niit.pojo.Card;
import com.niit.pojo.Student;

public class OneToOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
//		Card card = (Card)session.get(Card.class, 1);
//		System.out.println(card.getCardNo());
//		System.out.println(card.getStu().getStuName());
		
		Student stu = (Student)session.get(Student.class, 6);
		System.out.println(stu.getStuName());
		System.out.println(stu.getCard().getCardNo());
	}

}
