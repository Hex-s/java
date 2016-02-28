package com.niit.dao.iface;

import java.util.ArrayList;
import java.util.Calendar;

import com.niit.bean.Car;

/**
 * �����������ݲ����ӿ�
 * @author Administrator
 *
 */
public interface ICarDao {

	/**
	 * ���ݷ���ʱ�併�����г�������ǰ10�����ķ���
	 * @return
	 */
	public ArrayList<Car> sortCarsByPublishTime();
	/**
	 * ���ݱ�Ų�ѯ
	 * @param carId
	 * @return
	 */
	public Car findCarById(int carId);
	
	/**
	 * ���ݳ��ͱ��ɾ��
	 * @param typeId
	 */
	public void deleteCarsByTypeId(int typeId);
	
	/**
	 * ��ӳ���
	 * @param car
	 */
	public void addCar(Car car);
	
	/**
	 * ���ݼ۸����
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public ArrayList<Car> findCarsByPrice(double minPrice, double maxPrice);
	
	/**
	 * ����ʱ�����
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public ArrayList<Car> findCarsByTime(Calendar beginTime, Calendar endTime);
	
	/**
	 * ���ݳ��ͱ�Ų��ҳ���
	 * @param typeId
	 * @return
	 */
	public ArrayList<Car> findCarsByTypeId(int typeId);
}
