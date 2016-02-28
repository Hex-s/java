package com.niit.convert;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.niit.bean.Ware;
/**
 * 全局转换器
 * @author Administrator
 *
 */
public class GolbalConvert extends StrutsTypeConverter {

	/**
	 * 将请求参数转换成对象
	 */
	@Override
	public Object convertFromString(Map context, String[] array, Class toType) {
		System.out.println("进入了全局转换器");
		for(String val : array){
			System.out.println(val+":"+val.getClass());
		}
		//创建要转换的对象
		Ware ware = new Ware();
		//将数组中封装的请求参数写入转换后的对象
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
