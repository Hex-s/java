package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.CarType;

/**
 * ���Ͷ������ݲ����ӿ�
 * @author Administrator
 *
 */
public interface ICarTypeDao {

	/**
	 * ���ݱ�Ų��ҳ���
	 * @param carTypeId
	 * @return
	 */
	public CarType findCarTypeById(int carTypeId);
	
	/**
	 * ����Ʒ�Ʊ�Ų��ҳ���
	 * @param brandId
	 * @return
	 */
	public ArrayList<CarType> findListByBrandId(int brandId);
	
	/**
	 * ��ӳ���
	 * @param carType
	 */
	public void addCarType(CarType carType);
	
	/**
	 * ���ݱ��ɾ��
	 * @param carTypeId
	 */
	public void deleteCarType(int carTypeId);
}
