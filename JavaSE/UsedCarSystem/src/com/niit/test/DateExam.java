package com.niit.test;

import java.util.Date;

public class DateExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建Date类的实例，获取当前的系统时间
		Date date = new Date();
		//System.out.println(date);
		//以字符串的方式呈现时间
		//System.out.println(date.toLocaleString());
		//获取月份 0-11
//		System.out.println(date.getMonth());
//		//获取星期数 0-6
//		System.out.println(date.getDay());
//		//获取天
//		System.out.println(date.getDate());
//		//获取小时
//		System.out.println(date.getHours());
//		//获取分钟
//		System.out.println(date.getMinutes());
//		//获取秒
//		System.out.println(date.getSeconds());
		
		//设置时间 由于Date存在年份的问题，所以一般不通过创建实例来构建时间
		//Date date = new Date(2014,8,5);
		//更改月份
		date.setMonth(9);
		
		//通过另一个时间单位的毫秒值来构建新的时间
		Date newDate = new Date(date.getTime());
		//如果需要变更时间，一般使用Calendar类型来实现
		
		System.out.println(date.toLocaleString());
		System.out.println(newDate.toLocaleString());
	}

}
