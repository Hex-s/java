package com.niit.test;

import java.util.Locale;

public class LocaleExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Locale对象封装了区域语言信息
		//获取系统中的所有区域语言信息
		Locale[] locales = Locale.getAvailableLocales();
		for(Locale l : locales){
			System.out.println("国家代码："+l.getCountry()+"\t语言代码："+l.getLanguage()+"国家名称："+l.getDisplayCountry()+",语言名称："+l.getDisplayLanguage());
		}
		//构建Locale对象
		Locale locale = new Locale("zh", "CN");
		//设置当前默认的locale
		Locale.setDefault(locale);
	}

}
