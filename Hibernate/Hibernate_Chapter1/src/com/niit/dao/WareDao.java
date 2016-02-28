package com.niit.dao;

import org.hibernate.Session;

import com.niit.pojo.Ware;

public class WareDao extends CommonDao<Ware> {
	
	public Ware findWareById(int wareId){
		return findById(wareId, Ware.class);
	}
	public void deleteWareById(Ware ware){
		delete(ware);
	}
	public void modifyWare(Ware ware){
		update(ware);
	}
	public void saveWare(Ware ware){
		add(ware);
	}
}
