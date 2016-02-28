package com.niit.convert;

import java.util.Map;

import com.niit.bean.Ware;

import ognl.DefaultTypeConverter;

/**
 * �����BuyAction��ת������
 * @author Administrator
 *
 */
public class BuyActionConvert extends DefaultTypeConverter {
	/**
	 * ��дת������
	 */
	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		System.out.println("������convert");
		//value��ʾstruts�ڽ�ת�����������в���ת����String[]��Ľ��
		String[] array = (String[])value;
		for(String val : array){
			System.out.println(val+":"+val.getClass());
		}
		//����Ҫת���Ķ���
		Ware ware = new Ware();
		//�������з�װ���������д��ת����Ķ���
		ware.setId(Integer.parseInt(array[0]));
		ware.setWareName(array[1]);
		ware.setPrice(Double.parseDouble(array[2]));
		ware.setNum(Integer.parseInt(array[3]));
		return ware;
	}
	
}
