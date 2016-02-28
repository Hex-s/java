package com.niit.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//日历类  获取当前的系统时间
		//Calendar calendar = Calendar.getInstance();
		//将Calendar转换成Date类型
		//Date date = calendar.getTime();
		//System.out.println(date);
		
		//将Date类型转换成Calendar类型
//		Date date = new Date();
//		//改变了Date类型的时间
//		date.setHours(19);
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		//打印Calendar时间必须要将其转换成Date类型
//		System.out.println(calendar.getTime());
		
		Calendar calendar = Calendar.getInstance();
		//获取时间中的各个单位
//		System.out.println(calendar.get(Calendar.YEAR));
//		System.out.println(calendar.get(Calendar.MONTH));
//		System.out.println(calendar.get(Calendar.DATE));
		
		
		//根据年月日设置,时分秒使用系统时间
		//calendar.set(2010, 11, 1);
		//根据年月日时分秒设置
		//calendar.set(2010, 11, 1, 13, 2, 46);
		//设置时间中的各个单位
		calendar.set(Calendar.YEAR, 2008);
		calendar.set(Calendar.MONTH, 3);
		
		//创建一个新的时间
		Calendar newCalendar = Calendar.getInstance();
		//比较时间  0表示相同  -1表示小于(早于)要比较的时间  1表示大于比较时间
		//System.out.println(calendar.compareTo(newCalendar));
		
		//判断是否早于比较时间
		//System.out.println(calendar.before(newCalendar));
		//判断是否晚于比较时间
		//System.out.println(calendar.after(newCalendar));
		
		//根据时间单位对值进行数学计算
		//年份增加3年
		calendar.add(Calendar.YEAR, 3);
		//月份增加10个月
		calendar.add(Calendar.MONTH, 10);
		//减去4小时
		calendar.add(Calendar.HOUR, -4);
		
		System.out.println(calendar.getTime().toLocaleString());
		
		//格式化时间  参数表示时间中的单位
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		//格式化某个Date类型获取格式化后的字符串
		String time = format.format(calendar.getTime());
		System.out.println(time);
		
	}

}
