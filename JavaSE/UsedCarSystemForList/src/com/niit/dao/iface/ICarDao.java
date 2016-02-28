package com.niit.dao.iface;

import java.util.ArrayList;
import java.util.Calendar;

import com.niit.bean.Car;

/**
 * 汽车对象数据操作接口
 * @author Administrator
 *
 */
public interface ICarDao {

	/**
	 * 根据发布时间降序排列车辆查找前10辆车的方法
	 * @return
	 */
	public ArrayList<Car> sortCarsByPublishTime();
	/**
	 * 根据编号查询
	 * @param carId
	 * @return
	 */
	public Car findCarById(int carId);
	
	/**
	 * 根据车型编号删除
	 * @param typeId
	 */
	public void deleteCarsByTypeId(int typeId);
	
	/**
	 * 添加车辆
	 * @param car
	 */
	public void addCar(Car car);
	
	/**
	 * 根据价格查找
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public ArrayList<Car> findCarsByPrice(double minPrice, double maxPrice);
	
	/**
	 * 根据时间查找
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public ArrayList<Car> findCarsByTime(Calendar beginTime, Calendar endTime);
	
	/**
	 * 根据车型编号查找车辆
	 * @param typeId
	 * @return
	 */
	public ArrayList<Car> findCarsByTypeId(int typeId);
}
