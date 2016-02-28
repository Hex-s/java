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
	private static int brandId = 1000;
	private static int typeId = 1000;
	private static int carId = 1000;
	private static int userId = 0;
	
	/**
	 * ��ȡ�û���ŵķ���
	 * @return
	 */
	public static int getUserId(){
		return ++userId;
	}
	
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
		date.set(year, month-1, day, 0, 0, 0);
		return date;
	}
	/**
	 * ��ȡ��ʽ�����ʱ��
	 * @param calendar
	 * @return
	 */
	public static String formatDate(Calendar calendar){
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return formater.format(calendar.getTime());
	}
	/**
	 * �Ƚ�ʱ�������յķ���
	 * @param calendar
	 * @param compareCalendar ���Ƚϵ�ʱ��
	 * @return 1��ʾ���ڱȽ�ʱ��  0��ʾʱ����ͬ -1��ʾ���ڱȽ�ʱ��
	 */
	public static int compareDate(Calendar calendar, Calendar compareCalendar){
		int year = calendar.get(Calendar.YEAR);
		int compareYear = compareCalendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int compareMonth = compareCalendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int compareDate = compareCalendar.get(Calendar.DATE);
		//����ʱ��Ƚ�
		if(year > compareYear){
			return 1;
		}
		//�����ͬ�Ƚ��·�
		else if(year == compareYear){
			//����·ݴ�
			if(month > compareMonth){
				return 1;
			}
			else if(month < compareMonth){
				return -1;
			}
			//�·���ͬ�Ƚ���
			else{
				if(date > compareDate){
					return 1;
				}
				else if(date < compareDate){
					return -1;
				}
				else{
					return 0;
				}
			}
		}
		else{
			return -1;
		}
	}
}
