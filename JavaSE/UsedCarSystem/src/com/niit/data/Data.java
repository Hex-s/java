package com.niit.data;

import java.util.Calendar;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.util.CommonUtil;

/**
 * 数据类，存储了系统中需要持久保存的所有数据
 * @author Administrator
 *
 */
public class Data {
	//所有的用户信息
	public User[] userData;
	//所有的汽车信息
	public Car[] carData;
	//所有的品牌信息
	public Brand[] brandData;
	//所有的车型信息
	public CarType[] carTypeData;
	
	/**
	 * 初始化数据
	 */
	public void init(){
		//实例化存储的数组
		userData = new User[100];
		carData = new Car[100];
		brandData = new Brand[100];
		carTypeData = new CarType[100];
		
		/********初始化用户数据************/
		User user = new User();
		user.init();
		user.userName = "admin";
		user.password = "123";
		user.isAdmin = true;
		//写入数组
		userData[0] = user;
		/************初始化品牌数据*************/
		Brand brand1 = new Brand();
		brand1.brandId = CommonUtil.getBrandId();
		brand1.brandName = "大众";
		Brand brand2 = new Brand();
		brand2.brandId = CommonUtil.getBrandId();
		brand2.brandName = "奥迪";
		Brand brand3 = new Brand();
		brand3.brandId = CommonUtil.getBrandId();
		brand3.brandName = "宝马";
		//写入数组
		brandData[0] = brand1;
		brandData[1] = brand2;
		brandData[2] = brand3;
		
		/**************初始化车型数据****************/
		CarType type1 = new CarType();
		type1.typeId = CommonUtil.getTypeId();
		type1.brandId = 1001;
		type1.typeName = "帕萨特";
		
		CarType type2 = new CarType();
		type2.typeId = CommonUtil.getTypeId();
		type2.brandId = 1001;
		type2.typeName = "速腾";
		
		CarType type3 = new CarType();
		type3.typeId = CommonUtil.getTypeId();
		type3.brandId = 1001;
		type3.typeName = "迈腾";
		
		CarType type4 = new CarType();
		type4.typeId = CommonUtil.getTypeId();
		type4.brandId = 1002;
		type4.typeName = "A4L";
		
		CarType type5 = new CarType();
		type5.typeId = CommonUtil.getTypeId();
		type5.brandId = 1002;
		type5.typeName = "R8";
		
		CarType type6 = new CarType();
		type6.typeId = CommonUtil.getTypeId();
		type6.brandId = 1003;
		type6.typeName = "320i";
		
		CarType type7 = new CarType();
		type7.typeId = CommonUtil.getTypeId();
		type7.brandId = 1003;
		type7.typeName = "725i";
		//写入数据
		carTypeData[0] = type1;
		carTypeData[1] = type2;
		carTypeData[2] = type3;
		carTypeData[3] = type4;
		carTypeData[4] = type5;
		carTypeData[5] = type6;
		carTypeData[6] = type7;
		
		/**************初始化车辆数据****************/
		Car car1 = new Car();
		car1.carId = CommonUtil.getCarId();
		car1.brandId = 1001;
		car1.typeId = 1001;
		car1.price = 140000;
		car1.publishTime = CommonUtil.getCalendar(2012, 7, 5);
		
		Car car2 = new Car();
		car2.carId = CommonUtil.getCarId();
		car2.brandId = 1001;
		car2.typeId = 1002;
		car2.price = 110000;
		car2.publishTime = CommonUtil.getCalendar(2013, 6, 4);
		
		Car car3 = new Car();
		car3.carId = CommonUtil.getCarId();
		car3.brandId = 1001;
		car3.typeId = 1003;
		car3.price = 540000;
		car3.publishTime = CommonUtil.getCalendar(2014, 5, 5);
		
		Car car4 = new Car();
		car4.carId = CommonUtil.getCarId();
		car4.brandId = 1002;
		car4.typeId = 1004;
		car4.price = 230000;
		car4.publishTime = CommonUtil.getCalendar(2014, 4, 7);
		
		Car car5 = new Car();
		car5.carId = CommonUtil.getCarId();
		car5.brandId = 1002;
		car5.typeId = 1005;
		car5.price = 980000;
		car5.publishTime = CommonUtil.getCalendar(2014, 8, 2);
		
		Car car6 = new Car();
		car6.carId = CommonUtil.getCarId();
		car6.brandId = 1003;
		car6.typeId = 1006;
		car6.price = 220000;
		car6.publishTime = CommonUtil.getCalendar(2014, 8, 1);
		
		Car car7 = new Car();
		car7.carId = CommonUtil.getCarId();
		car7.brandId = 1003;
		car7.typeId = 1007;
		car7.price = 480000;
		car7.publishTime = CommonUtil.getCalendar(2013, 8, 15);
		//写入数据
		carData[0] = car1;
		carData[1] = car2;
		carData[2] = car3;
		carData[3] = car4;
		carData[4] = car5;
		carData[5] = car6;
		carData[6] = car7;
	}
}
