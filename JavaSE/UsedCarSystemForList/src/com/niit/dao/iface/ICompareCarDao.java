package com.niit.dao.iface;

import java.util.ArrayList;

/**
 * 对比车辆数据操作接口
 * @author Administrator
 *
 */
public interface ICompareCarDao {

	/**
	 * 添加对比信息
	 * @param userId
	 * @param carId
	 */
	public void addCompareCar(int userId, int carId);
	
	/**
	 * 删除对比信息
	 * @param userId
	 * @param carId
	 */
	public void deleteCompareCar(int userId, int carId);
	
	/**
	 * 根据用户编号查询对比车辆
	 * @param userId
	 * @return
	 */
	public ArrayList<Integer> findCarsByUserId(int userId);
}
