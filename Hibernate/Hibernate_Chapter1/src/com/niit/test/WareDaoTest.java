package com.niit.test;

import com.niit.dao.WareDao;
import com.niit.pojo.Ware;

public class WareDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WareDao dao = new WareDao();
		//查找
		Ware ware = dao.findWareById(1);
		if(ware != null){
			System.out.println(ware.getWareName());
		}
		//修改价格
		ware.setPrice(1000);
		dao.modifyWare(ware);
	}

}
