package com.niit.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 工具类，提供了和项目业务功能无关的常用方法，工具类应具备一定的通用性
 * @author Administrator
 *
 */
public class CommonUtil {
	//静态属性和方法常驻内存，不需要类进行实例化就已经存在于内存中，因此可以直接通过类名.属性名(方法名)访问
	private static int brandId = 1000;
	private static int typeId = 1000;
	private static int carId = 1000;
	private static int userId = 0;
	
	/**
	 * 获取用户编号的方法
	 * @return
	 */
	public static int getUserId(){
		return ++userId;
	}
	
	/**
	 * 获取品牌编号的方法
	 * @return
	 */
	public static int getBrandId(){
		brandId++;
		return brandId;
	}
	/**
	 * 获取车型编号的方法
	 * @return
	 */
	public static int getTypeId(){
		typeId++;
		return typeId;
	}
	/**
	 * 获取汽车编号的方法
	 * @return
	 */
	public static int getCarId(){
		carId++;
		return carId;
	}
	/**
	 * 获取指定的日期
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
	 * 获取格式化后的时间
	 * @param calendar
	 * @return
	 */
	public static String formatDate(Calendar calendar){
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return formater.format(calendar.getTime());
	}
	/**
	 * 比较时间年月日的方法
	 * @param calendar
	 * @param compareCalendar 被比较的时间
	 * @return 1表示晚于比较时间  0表示时间相同 -1表示早于比较时间
	 */
	public static int compareDate(Calendar calendar, Calendar compareCalendar){
		int year = calendar.get(Calendar.YEAR);
		int compareYear = compareCalendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int compareMonth = compareCalendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int compareDate = compareCalendar.get(Calendar.DATE);
		//进行时间比较
		if(year > compareYear){
			return 1;
		}
		//年份相同比较月份
		else if(year == compareYear){
			//如果月份大
			if(month > compareMonth){
				return 1;
			}
			else if(month < compareMonth){
				return -1;
			}
			//月份相同比较天
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
