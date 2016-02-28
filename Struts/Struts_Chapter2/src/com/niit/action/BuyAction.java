package com.niit.action;

import com.niit.bean.Ware;
import com.opensymphony.xwork2.Action;

public class BuyAction implements Action {
	
	private Ware ware;
	
	public String execute() throws Exception {
		System.out.println("Ω¯»Î¡Àbuy action");
		System.out.println(ware.getWareName());
		System.out.println(ware.getPrice());
		return SUCCESS;
	}
	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
	}
	
}
