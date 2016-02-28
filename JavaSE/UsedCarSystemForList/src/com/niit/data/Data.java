package com.niit.data;

import java.util.ArrayList;
import java.util.HashMap;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.util.CommonUtil;

/**
 * ������
 * @author Administrator
 *
 */
public class Data {

	//ʹ�ü��ϴ洢���е�����
	//���е��û���Ϣ
	private ArrayList<User> userData;
	//���е�������Ϣ
	private ArrayList<Car> carData;
	//���е�Ʒ����Ϣ
	private ArrayList<Brand> brandData;
	//���еĳ�����Ϣ
	private ArrayList<CarType> carTypeData;
	//�����û��ĶԱ���Ϣ ����ʾ�û���ţ�ֵ��ʾ������ż���
	private HashMap<Integer, ArrayList<Integer>> compareCarData;
	
	/**
	 *  ��ʼ��
	 */
	public Data(){
		//��ʼ������������ݵļ���
		userData = new ArrayList<User>();
		carData = new ArrayList<Car>();
		brandData = new ArrayList<Brand>();
		carTypeData = new ArrayList<CarType>();
		compareCarData = new HashMap<Integer, ArrayList<Integer>>();
		//��ʼ���û���Ϣ
		User user = new User("admin", "0000", 10000, true);
		userData.add(user);
		//��ʼ��Ʒ����Ϣ
		brandData.add(new Brand("����"));
		brandData.add(new Brand("�µ�"));
		brandData.add(new Brand("����"));
		//��ʼ��������Ϣ
		carTypeData.add(new CarType("E200", 1001));
		carTypeData.add(new CarType("S350", 1001));
		carTypeData.add(new CarType("TT", 1002));
		carTypeData.add(new CarType("����", 1003));
		carTypeData.add(new CarType("CC", 1003));
		carTypeData.add(new CarType("����", 1003));
		//��ʼ��������Ϣ
		carData.add(new Car(1001, "2.0", 54000, 210000, "�Զ���", CommonUtil.getCalendar(2010, 3, 12), CommonUtil.getCalendar(2013, 12, 6), false));
		carData.add(new Car(1001, "3.0", 84000, 300000, "�Զ���", CommonUtil.getCalendar(2012, 5, 26), CommonUtil.getCalendar(2013, 5, 7), false));
		carData.add(new Car(1001, "2.0T", 36000, 250000, "�Զ���", CommonUtil.getCalendar(2013, 10, 9), CommonUtil.getCalendar(2014, 2, 4), false));
		carData.add(new Car(1002, "3.0", 124000, 750000, "�Զ���", CommonUtil.getCalendar(2008, 8, 22), CommonUtil.getCalendar(2014, 3, 16), false));
		carData.add(new Car(1002, "3.0T", 38000, 610000, "�Զ���", CommonUtil.getCalendar(2010, 7, 13), CommonUtil.getCalendar(2012, 8, 4), false));
		carData.add(new Car(1003, "3.0T", 35000, 680000, "�Զ���", CommonUtil.getCalendar(2009, 4, 25), CommonUtil.getCalendar(2014, 3, 12), false));
		carData.add(new Car(1004, "3.0", 82000, 350000, "�Զ���", CommonUtil.getCalendar(2013, 5, 30), CommonUtil.getCalendar(2014, 2, 31), false));
		carData.add(new Car(1004, "5.0", 72000, 870000, "�Զ���", CommonUtil.getCalendar(2014, 4, 9), CommonUtil.getCalendar(2013, 6, 29), false));
		carData.add(new Car(1005, "2.0", 134000, 140000, "�ֶ���", CommonUtil.getCalendar(2007, 6, 28), CommonUtil.getCalendar(2014, 8, 5), false));
		carData.add(new Car(1005, "2.0", 91000, 190000, "�Զ���", CommonUtil.getCalendar(2009, 5, 15), CommonUtil.getCalendar(2013, 9, 2), false));
		carData.add(new Car(1006, "2.0", 132000, 125000, "�ֶ���", CommonUtil.getCalendar(2008, 7, 27), CommonUtil.getCalendar(2012, 3, 11), false));
		carData.add(new Car(1006, "2.4", 92000, 170000, "�Զ���", CommonUtil.getCalendar(2010, 10, 11), CommonUtil.getCalendar(2014, 11, 28), true));
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
