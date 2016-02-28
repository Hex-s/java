package com.niit.convert;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.niit.bean.Ware;
/**
 * ȫ��ת����
 * @author Administrator
 *
 */
public class GolbalConvert extends StrutsTypeConverter {

	/**
	 * ���������ת���ɶ���
	 */
	@Override
	public Object convertFromString(Map context, String[] array, Class toType) {
		System.out.println("������ȫ��ת����");
		for(String val : array){
			System.out.println(val+":"+val.getClass());
		}
		//����Ҫת���Ķ���
		Ware ware = new Ware();
		//�������з�װ���������д��ת����Ķ���
		try {
			ware.setId(Integer.parseInt(array[0]));
			ware.setWareName(array[1]);
			ware.setPrice(Double.parseDouble(array[2]));
			ware.setNum(Integer.parseInt(array[3]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
