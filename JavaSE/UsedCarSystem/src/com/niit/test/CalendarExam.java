package com.niit.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//������  ��ȡ��ǰ��ϵͳʱ��
		//Calendar calendar = Calendar.getInstance();
		//��Calendarת����Date����
		//Date date = calendar.getTime();
		//System.out.println(date);
		
		//��Date����ת����Calendar����
//		Date date = new Date();
//		//�ı���Date���͵�ʱ��
//		date.setHours(19);
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		//��ӡCalendarʱ�����Ҫ����ת����Date����
//		System.out.println(calendar.getTime());
		
		Calendar calendar = Calendar.getInstance();
		//��ȡʱ���еĸ�����λ
//		System.out.println(calendar.get(Calendar.YEAR));
//		System.out.println(calendar.get(Calendar.MONTH));
//		System.out.println(calendar.get(Calendar.DATE));
		
		
		//��������������,ʱ����ʹ��ϵͳʱ��
		//calendar.set(2010, 11, 1);
		//����������ʱ��������
		//calendar.set(2010, 11, 1, 13, 2, 46);
		//����ʱ���еĸ�����λ
		calendar.set(Calendar.YEAR, 2008);
		calendar.set(Calendar.MONTH, 3);
		
		//����һ���µ�ʱ��
		Calendar newCalendar = Calendar.getInstance();
		//�Ƚ�ʱ��  0��ʾ��ͬ  -1��ʾС��(����)Ҫ�Ƚϵ�ʱ��  1��ʾ���ڱȽ�ʱ��
		//System.out.println(calendar.compareTo(newCalendar));
		
		//�ж��Ƿ����ڱȽ�ʱ��
		//System.out.println(calendar.before(newCalendar));
		//�ж��Ƿ����ڱȽ�ʱ��
		//System.out.println(calendar.after(newCalendar));
		
		//����ʱ�䵥λ��ֵ������ѧ����
		//�������3��
		calendar.add(Calendar.YEAR, 3);
		//�·�����10����
		calendar.add(Calendar.MONTH, 10);
		//��ȥ4Сʱ
		calendar.add(Calendar.HOUR, -4);
		
		System.out.println(calendar.getTime().toLocaleString());
		
		//��ʽ��ʱ��  ������ʾʱ���еĵ�λ
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss");
		//��ʽ��ĳ��Date���ͻ�ȡ��ʽ������ַ���
		String time = format.format(calendar.getTime());
		System.out.println(time);
		
	}

}
