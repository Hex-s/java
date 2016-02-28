package com.niit.convert;

import java.util.Map;

import com.niit.bean.Ware;

import ognl.DefaultTypeConverter;

/**
 * 针对于BuyAction的转换器类
 * @author Administrator
 *
 */
public class BuyActionConvert extends DefaultTypeConverter {
	/**
	 * 重写转换方法
	 */
	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		System.out.println("进入了convert");
		//value表示struts内建转换器将请求中参数转换成String[]后的结果
		String[] array = (String[])value;
		for(String val : array){
			System.out.println(val+":"+val.getClass());
		}
		//创建要转换的对象
		Ware ware = new Ware();
		//将数组中封装的请求参数写入转换后的对象
		ware.setId(Integer.parseInt(array[0]));
		ware.setWareName(array[1]);
		ware.setPrice(Double.parseDouble(array[2]));
		ware.setNum(Integer.parseInt(array[3]));
		return ware;
	}
	
}
