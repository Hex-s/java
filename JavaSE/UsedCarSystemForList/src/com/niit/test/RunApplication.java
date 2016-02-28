package com.niit.test;

import com.niit.data.Data;
import com.niit.logic.CarSystem;

public class RunApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data = new Data();
		
		CarSystem sys = new CarSystem(data);
		sys.start();

	}

}
