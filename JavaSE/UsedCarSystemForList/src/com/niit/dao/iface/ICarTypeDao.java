package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.CarType;

/**
 * 车型对象数据操作接口
 * @author Administrator
 *
 */
public interface ICarTypeDao {

	/**
	 * 根据编号查找车型
	 * @param carTypeId
	 * @return
	 */
	public CarType findCarTypeById(int carTypeId);
	
	/**
	 * 根据品牌编号查找车型
	 * @param brandId
	 * @return
	 */
	public ArrayList<CarType> findListByBrandId(int brandId);
	
	/**
	 * 添加车型
	 * @param carType
	 */
	public void addCarType(CarType carType);
	
	/**
	 * 根据编号删除
	 * @param carTypeId
	 */
	public void deleteCarType(int carTypeId);
}
