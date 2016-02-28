package com.niit.test;

import com.niit.dao.WareDao;
import com.niit.pojo.Ware;

public class WareDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WareDao dao = new WareDao();
		//����
		Ware ware = dao.findWareById(1);
		if(ware != null){
			System.out.println(ware.getWareName());
		}
		//�޸ļ۸�
		ware.setPrice(1000);
		dao.modifyWare(ware);
	}

}
