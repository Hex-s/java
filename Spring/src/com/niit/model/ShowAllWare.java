package com.niit.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Ware;
import com.niit.dao.iface.IWareDao;
import com.niit.dao.impl.WareDao;

public class ShowAllWare implements IModel {
	/**
	 * 如果该dao对象是交由spring管理，并且该dao实现了AOP切入，则spring注入的是该dao的代理对象
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
