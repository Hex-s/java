package com.niit.test;

import java.util.Date;

public class DateExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����Date���ʵ������ȡ��ǰ��ϵͳʱ��
		Date date = new Date();
		//System.out.println(date);
		//���ַ����ķ�ʽ����ʱ��
		//System.out.println(date.toLocaleString());
		//��ȡ�·� 0-11
//		System.out.println(date.getMonth());
//		//��ȡ������ 0-6
//		System.out.println(date.getDay());
//		//��ȡ��
//		System.out.println(date.getDate());
//		//��ȡСʱ
//		System.out.println(date.getHours());
//		//��ȡ����
//		System.out.println(date.getMinutes());
//		//��ȡ��
//		System.out.println(date.getSeconds());
		
		//����ʱ�� ����Date������ݵ����⣬����һ�㲻ͨ������ʵ��������ʱ��
		//Date date = new Date(2014,8,5);
		//�����·�
		date.setMonth(9);
		
		//ͨ����һ��ʱ�䵥λ�ĺ���ֵ�������µ�ʱ��
		Date newDate = new Date(date.getTime());
		//�����Ҫ���ʱ�䣬һ��ʹ��Calendar������ʵ��
		
		System.out.println(date.toLocaleString());
		System.out.println(newDate.toLocaleString());
	}

}
