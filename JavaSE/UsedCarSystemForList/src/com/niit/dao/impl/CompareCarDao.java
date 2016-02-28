package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;

import com.niit.bean.Car;
import com.niit.dao.iface.ICompareCarDao;
import com.niit.data.Data;

public class CompareCarDao implements ICompareCarDao {

	private HashMap<Integer, ArrayList<Integer>> compareCarData;
	private CarDao carDao;
	
	public CompareCarDao(Data data){
		this.compareCarData = data.getCompareCarData();
		carDao = new CarDao(data);
	}
	@Override
	public void addCompareCar(int userId, int carId) {
		// TODO Auto-generated method stub
		//���ݼ�����ֵ
		ArrayList<Integer> cars = compareCarData.get(userId);
		//�ж�ֵ�ļ����Ƿ�Ϊnull
		if(cars == null){
			//���Ϊnull����ζ���û��ǵ�һ�ζԱȳ���
			cars = new ArrayList<Integer>();
		}
		//���������д�뼯��
		cars.add(carId);
		//���Ĺ���ֵ����д�뼯��
		compareCarData.put(userId, cars);
	}

	@Override
	public void deleteCompareCar(int userId, int carId) {
		//���ݼ���ȡֵ
		ArrayList<Integer> cars = compareCarData.get(userId);
		cars.remove(carId);
		//���޸ĺ�ĳ�����������д�ؼ���
		compareCarData.put(userId, cars);
	}
	@Override
	public ArrayList<Integer> findCarsByUserId(int userId) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(compareCarData.get(userId) != null){
			list = compareCarData.get(userId);
		}
		return list;
	}

}
