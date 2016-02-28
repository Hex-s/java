package com.niit.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Ware;
import com.niit.dao.iface.IWareDao;
import com.niit.dao.impl.WareDao;

public class ModifyWare implements IModel {
	
	private IWareDao wareDao;
	
	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//获取商品编号
		int wareId = Integer.parseInt(request.getParameter("wareId"));
		Ware ware = new Ware();
		ware.setWareId(wareId);
		ware.setPrice(500);
		wareDao.modifyWare(ware);
		return "init.do?key=init";
	}
	public IWareDao getWareDao() {
		return wareDao;
	}

	public void setWareDao(IWareDao wareDao) {
		this.wareDao = wareDao;
	}


	
}
