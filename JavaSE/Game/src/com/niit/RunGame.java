package com.niit;

public class RunGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化地图
		Map map = new Map();
		//初始化地图
		map.init();
		//显示地图
		map.drawMap(0,0);
	}

}
