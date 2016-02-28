package com.niit.test;

import java.util.Calendar;

public class Exam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//查找2010年到当前年份间上牌的车辆信息
		
		//汽车的上牌时间
		Calendar cardDate;
		
		//当前年份的时间
		Calendar afterDate = Calendar.getInstance();
		//2010年的时间
		Calendar beforeDate = Calendar.getInstance();
		beforeDate.set(Calendar.YEAR, 2010);
		
//		if(cardDate.after(beforeDate) && cardDate.before(afterDate)){
//			
//		}
		
//		上牌时间 2010.5.4 17:30
//		起始时间 2010.8.13 11:52
		//根据经历过的总毫秒值进行判断
//		if(cardDate.getTimeInMillis() >= beforeDate.getTimeInMillis() && cardDate.getTimeInMillis() <= afterDate.getTimeInMillis()){
//			
//		}
		
		
	}

}
