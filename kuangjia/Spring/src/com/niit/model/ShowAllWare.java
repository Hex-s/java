package com.niit.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Ware;
import com.niit.dao.impl.WareDao;

public class ShowAllWare implements IModel {
	
	private WareDao wareDao;
	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList<Ware> list = wareDao.findAll();
		request.setAttribute("wareList", list);
		return "info.jsp";
	}

	public WareDao getWareDao() {
		return wareDao;
	}

	public void setWareDao(WareDao wareDao) {
		this.wareDao = wareDao;
	}

}
