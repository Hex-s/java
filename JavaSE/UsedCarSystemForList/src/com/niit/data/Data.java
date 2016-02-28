package com.niit.data;

import java.util.ArrayList;
import java.util.HashMap;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.util.CommonUtil;

/**
 * 数据类
 * @author Administrator
 *
 */
public class Data {

	//使用集合存储所有的数据
	//所有的用户信息
	private ArrayList<User> userData;
	//所有的汽车信息
	private ArrayList<Car> carData;
	//所有的品牌信息
	private ArrayList<Brand> brandData;
	//所有的车型信息
	private ArrayList<CarType> carTypeData;
	//所有用户的对比信息 键表示用户编号，值表示汽车编号集合
	private HashMap<Integer, ArrayList<Integer>> compareCarData;
	
	/**
	 *  初始化
	 */
	public Data(){
		//初始化各个存放数据的集合
		userData = new ArrayList<User>();
		carData = new ArrayList<Car>();
		brandData = new ArrayList<Brand>();
		carTypeData = new ArrayList<CarType>();
		compareCarData = new HashMap<Integer, ArrayList<Integer>>();
		//初始化用户信息
		User user = new User("admin", "0000", 10000, true);
		userData.add(user);
		//初始化品牌信息
		brandData.add(new Brand("奔驰"));
		brandData.add(new Brand("奥迪"));
		brandData.add(new Brand("大众"));
		//初始化车型信息
		carTypeData.add(new CarType("E200", 1001));
		carTypeData.add(new CarType("S350", 1001));
		carTypeData.add(new CarType("TT", 1002));
		carTypeData.add(new CarType("辉腾", 1003));
		carTypeData.add(new CarType("CC", 1003));
		carTypeData.add(new CarType("迈腾", 1003));
		//初始化车辆信息
		carData.add(new Car(1001, "2.0", 54000, 210000, "自动挡", CommonUtil.getCalendar(2010, 3, 12), CommonUtil.getCalendar(2013, 12, 6), false));
		carData.add(new Car(1001, "3.0", 84000, 300000, "自动挡", CommonUtil.getCalendar(2012, 5, 26), CommonUtil.getCalendar(2013, 5, 7), false));
		carData.add(new Car(1001, "2.0T", 36000, 250000, "自动挡", CommonUtil.getCalendar(2013, 10, 9), CommonUtil.getCalendar(2014, 2, 4), false));
		carData.add(new Car(1002, "3.0", 124000, 750000, "自动挡", CommonUtil.getCalendar(2008, 8, 22), CommonUtil.getCalendar(2014, 3, 16), false));
		carData.add(new Car(1002, "3.0T", 38000, 610000, "自动挡", CommonUtil.getCalendar(2010, 7, 13), CommonUtil.getCalendar(2012, 8, 4), false));
		carData.add(new Car(1003, "3.0T", 35000, 680000, "自动挡", CommonUtil.getCalendar(2009, 4, 25), CommonUtil.getCalendar(2014, 3, 12), false));
		carData.add(new Car(1004, "3.0", 82000, 350000, "自动挡", CommonUtil.getCalendar(2013, 5, 30), CommonUtil.getCalendar(2014, 2, 31), false));
		carData.add(new Car(1004, "5.0", 72000, 870000, "自动挡", CommonUtil.getCalendar(2014, 4, 9), CommonUtil.getCalendar(2013, 6, 29), false));
		carData.add(new Car(1005, "2.0", 134000, 140000, "手动挡", CommonUtil.getCalendar(2007, 6, 28), CommonUtil.getCalendar(2014, 8, 5), false));
		carData.add(new Car(1005, "2.0", 91000, 190000, "自动挡", CommonUtil.getCalendar(2009, 5, 15), CommonUtil.getCalendar(2013, 9, 2), false));
		carData.add(new Car(1006, "2.0", 132000, 125000, "手动挡", CommonUtil.getCalendar(2008, 7, 27), CommonUtil.getCalendar(2012, 3, 11), false));
		carData.add(new Car(1006, "2.4", 92000, 170000, "自动挡", CommonUtil.getCalendar(2010, 10, 11), CommonUtil.getCalendar(2014, 11, 28), true));
	}

	public ArrayList<User> getUserData() {
		return userData;
	}

	public ArrayList<Car> getCarData() {
		return carData;
	}

	public ArrayList<Brand> getBrandData() {
		return brandData;
	}

	public ArrayList<CarType> getCarTypeData() {
		return carTypeData;
	}

	public HashMap<Integer, ArrayList<Integer>> getCompareCarData() {
		return compareCarData;
	}

	public void setCompareCarData(
			HashMap<Integer, ArrayList<Integer>> compareCarData) {
		this.compareCarData = compareCarData;
	}

	public void setUserData(ArrayList<User> userData) {
		this.userData = userData;
	}

	public void setCarData(ArrayList<Car> carData) {
		this.carData = carData;
	}

	public void setBrandData(ArrayList<Brand> brandData) {
		this.brandData = brandData;
	}

	public void setCarTypeData(ArrayList<CarType> carTypeData) {
		this.carTypeData = carTypeData;
	}
	
}
