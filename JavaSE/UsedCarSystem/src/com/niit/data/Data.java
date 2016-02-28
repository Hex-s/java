package com.niit.data;

import java.util.Calendar;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.util.CommonUtil;

/**
 * �����࣬�洢��ϵͳ����Ҫ�־ñ������������
 * @author Administrator
 *
 */
public class Data {
	//���е��û���Ϣ
	public User[] userData;
	//���е�������Ϣ
	public Car[] carData;
	//���е�Ʒ����Ϣ
	public Brand[] brandData;
	//���еĳ�����Ϣ
	public CarType[] carTypeData;
	
	/**
	 * ��ʼ������
	 */
	public void init(){
		//ʵ�����洢������
		userData = new User[100];
		carData = new Car[100];
		brandData = new Brand[100];
		carTypeData = new CarType[100];
		
		/********��ʼ���û�����************/
		User user = new User();
		user.init();
		user.userName = "admin";
		user.password = "123";
		user.isAdmin = true;
		//д������
		userData[0] = user;
		/************��ʼ��Ʒ������*************/
		Brand brand1 = new Brand();
		brand1.brandId = CommonUtil.getBrandId();
		brand1.brandName = "����";
		Brand brand2 = new Brand();
		brand2.brandId = CommonUtil.getBrandId();
		brand2.brandName = "�µ�";
		Brand brand3 = new Brand();
		brand3.brandId = CommonUtil.getBrandId();
		brand3.brandName = "����";
		//д������
		brandData[0] = brand1;
		brandData[1] = brand2;
		brandData[2] = brand3;
		
		/**************��ʼ����������****************/
		CarType type1 = new CarType();
		type1.typeId = CommonUtil.getTypeId();
		type1.brandId = 1001;
		type1.typeName = "������";
		
		CarType type2 = new CarType();
		type2.typeId = CommonUtil.getTypeId();
		type2.brandId = 1001;
		type2.typeName = "����";
		
		CarType type3 = new CarType();
		type3.typeId = CommonUtil.getTypeId();
		type3.brandId = 1001;
		type3.typeName = "����";
		
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
		//д������
		carTypeData[0] = type1;
		carTypeData[1] = type2;
		carTypeData[2] = type3;
		carTypeData[3] = type4;
		carTypeData[4] = type5;
		carTypeData[5] = type6;
		carTypeData[6] = type7;
		
		/**************��ʼ����������****************/
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
		//д������
		carData[0] = car1;
		carData[1] = car2;
		carData[2] = car3;
		carData[3] = car4;
		carData[4] = car5;
		carData[5] = car6;
		carData[6] = car7;
	}
}
