package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;

import com.niit.bean.Car;
import com.niit.dao.iface.ICarDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class CarDao implements ICarDao {

	private ArrayList<Car> carData;
	
	public CarDao(Data data){
		this.carData = data.getCarData();
	}
	
	@Override
	public void addCar(Car car) {
		// TODO Auto-generated method stub
		carData.add(car);
	}

	@Override
	public void deleteCarsByTypeId(int typeId) {
		//根据车型编号查找车辆
		ArrayList<Car> list = new ArrayList<Car>();
		//遍历所有车辆
		for(Car car : carData){
			//判断车型编号
			if(car.getTypeId() == typeId){
				//将车型相同的车辆添加至集合
				list.add(car);
			}
		}
		//将找到的车辆都删除
		carData.removeAll(list);
		
	}

	@Override
	public Car findCarById(int carId) {
		// TODO Auto-generated method stub
		for(Car car : carData){
			if(car.getCarId() == carId){
				return car;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Car> findCarsByPrice(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		ArrayList<Car> list = new ArrayList<Car>();
		for(Car car : carData){
			//判断车辆价格是否在区间内
			if(car.getPrice() >= minPrice && car.getPrice() <= maxPrice){
				//添加车辆
				list.add(car);
			}
		}
		return list;
	}

	@Override
	public ArrayList<Car> findCarsByTime(Calendar beginTime, Calendar endTime) {
		// TODO Auto-generated method stub
		ArrayList<Car> list = new ArrayList<Car>();
		//遍历所有汽车
		for(Car car : carData){
			//判断上牌时间是否在区间内
			if(CommonUtil.compareDate(car.getBoardTime(), beginTime) >= 0 && CommonUtil.compareDate(car.getBoardTime(), endTime) <= 0){
				list.add(car);
			}
		}
		return list;
	}

	@Override
	public ArrayList<Car> sortCarsByPublishTime() {
		// TODO Auto-generated method stub
		ArrayList<Car> list = new ArrayList<Car>();
		//排序
		for(int i = 1; i < carData.size(); i++){
			for(int j = 0; j < carData.size()-i; j++){
				//根据时间进行比较
				if(carData.get(j).getPublishTime().before(carData.get(j+1).getPublishTime())){
					//将集合中的车辆进行交换
					Car tempCar = carData.get(j);
					carData.set(j, carData.get(j+1));
					carData.set(j+1, tempCar);
				}
			}
		}
		//计数器
		int count = 0;
		for(Car car : carData){
			if(!car.isSell()){
				//累计循环的次数
				count++;
				//将集合中的元素添加至要查询的集合中
				list.add(car);
				//如果已经加满10辆车,退出循环
				if(count == 10){
					break;
				}
			}
		}
		return list;
	}

	@Override
	public ArrayList<Car> findCarsByTypeId(int typeId) {
		ArrayList<Car> list = new ArrayList<Car>();
		//遍历所有的车辆
		for(Car car : carData){
			if(car.getTypeId() == typeId){
				list.add(car);
			}
		}
		return list;
	}
	
	

}
