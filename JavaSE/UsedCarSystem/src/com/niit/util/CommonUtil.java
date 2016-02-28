package com.niit.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * �����࣬�ṩ�˺���Ŀҵ�����޹صĳ��÷�����������Ӧ�߱�һ����ͨ����
 * @author Administrator
 *
 */
public class CommonUtil {
	//��̬���Ժͷ�����פ�ڴ棬����Ҫ�����ʵ�������Ѿ��������ڴ��У���˿���ֱ��ͨ������.������(������)����
	public static int brandId = 1000;
	static int typeId = 1000;
	static int carId = 1000;
	/**
	 * ��ȡƷ�Ʊ�ŵķ���
	 * @return
	 */
	public static int getBrandId(){
		brandId++;
		return brandId;
	}
	/**
	 * ��ȡ���ͱ�ŵķ���
	 * @return
	 */
	public static int getTypeId(){
		typeId++;
		return typeId;
	}
	/**
	 * ��ȡ������ŵķ���
	 * @return
	 */
	public static int getCarId(){
		carId++;
		return carId;
	}
	/**
	 * ��ȡָ��������
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Calendar getCalendar(int year, int month, int day){
		Calendar date = Calendar.getInstance();
		date.set(year, month-1, day);
		return date;
	}
	/**
	 * ��ȡ��ʽ�����ʱ��
	 * @param calendar
	 * @return
	 */
	public static String formatDate(Calendar calendar){
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		return formater.format(calendar.getTime());
	}
}
