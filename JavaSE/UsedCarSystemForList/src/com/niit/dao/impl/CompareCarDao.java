package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;

import com.niit.bean.Car;
import com.niit.dao.iface.ICompareCarDao;
import com.niit.data.Data;

public class CompareCarDao implements ICompareCarDao {

	private HashMap<Integer, ArrayList<Integer>> compareCarData;
	private CarDao carDao;
	
	public CompareCarDao(Data data){
		this.compareCarData = data.getCompareCarData();
		carDao = new CarDao(data);
	}
	@Override
	public void addCompareCar(int userId, int carId) {
		// TODO Auto-generated method stub
		//根据键查找值
		ArrayList<Integer> cars = compareCarData.get(userId);
		//判断值的集合是否为null
		if(cars == null){
			//如果为null就意味着用户是第一次对比车辆
			cars = new ArrayList<Integer>();
		}
		//将汽车编号写入集合
		cars.add(carId);
		//将改过的值重新写入集合
		compareCarData.put(userId, cars);
	}

	@Override
	public void deleteCompareCar(int userId, int carId) {
		//根据键获取值
		ArrayList<Integer> cars = compareCarData.get(userId);
		cars.remove(carId);
		//将修改后的车辆集合重新写回集合
		compareCarData.put(userId, cars);
	}
	@Override
	public ArrayList<Integer> findCarsByUserId(int userId) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(compareCarData.get(userId) != null){
			list = compareCarData.get(userId);
		}
		return list;
	}

}
