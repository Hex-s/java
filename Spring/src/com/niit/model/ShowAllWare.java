package com.niit.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Ware;
import com.niit.dao.iface.IWareDao;
import com.niit.dao.impl.WareDao;

public class ShowAllWare implements IModel {
	/**
	 * �����dao�����ǽ���spring�������Ҹ�daoʵ����AOP���룬��springע����Ǹ�dao�Ĵ������
	 */
	private IWareDao wareDao;
	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList<Ware> list = wareDao.findAll();
		request.setAttribute("wareList", list);
		return "info.jsp";
	}

	public IWareDao getWareDao() {
		return wareDao;
	}

	public void setWareDao(IWareDao wareDao) {
		this.wareDao = wareDao;
	}

	

}
