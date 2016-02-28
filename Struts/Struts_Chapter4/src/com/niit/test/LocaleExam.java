package com.niit.test;

import java.util.Locale;

public class LocaleExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Locale�����װ������������Ϣ
		//��ȡϵͳ�е���������������Ϣ
		Locale[] locales = Locale.getAvailableLocales();
		for(Locale l : locales){
			System.out.println("���Ҵ��룺"+l.getCountry()+"\t���Դ��룺"+l.getLanguage()+"�������ƣ�"+l.getDisplayCountry()+",�������ƣ�"+l.getDisplayLanguage());
		}
		//����Locale����
		Locale locale = new Locale("zh", "CN");
		//���õ�ǰĬ�ϵ�locale
		Locale.setDefault(locale);
	}

}
