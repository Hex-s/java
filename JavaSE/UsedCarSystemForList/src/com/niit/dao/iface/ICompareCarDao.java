package com.niit.dao.iface;

import java.util.ArrayList;

/**
 * �Աȳ������ݲ����ӿ�
 * @author Administrator
 *
 */
public interface ICompareCarDao {

	/**
	 * ��ӶԱ���Ϣ
	 * @param userId
	 * @param carId
	 */
	public void addCompareCar(int userId, int carId);
	
	/**
	 * ɾ���Ա���Ϣ
	 * @param userId
	 * @param carId
	 */
	public void deleteCompareCar(int userId, int carId);
	
	/**
	 * �����û���Ų�ѯ�Աȳ���
	 * @param userId
	 * @return
	 */
	public ArrayList<Integer> findCarsByUserId(int userId);
}
