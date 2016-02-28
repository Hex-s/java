package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.bean.CarType;
import com.niit.dao.iface.ICarTypeDao;
import com.niit.data.Data;

public class CarTypeDao implements ICarTypeDao {

	private ArrayList<CarType> carTypeData;
	
	public CarTypeDao(Data data){
		this.carTypeData = data.getCarTypeData();
	}
	@Override
	public void addCarType(CarType carType) {
		// TODO Auto-generated method stub
		carTypeData.add(carType);
	}

	@Override
	public void deleteCarType(int carTypeId) {
		// TODO Auto-generated method stub
		CarType carType = findCarTypeById(carTypeId);
		if(carType != null){
			carTypeData.remove(carType);
		}
	}

	@Override
	public CarType findCarTypeById(int carTypeId) {
		// TODO Auto-generated method stub
		for(CarType carType : carTypeData){
			if(carType.getTypeId() == carTypeId){
				return carType;
			}
		}
		return null;
	}

	@Override
	public ArrayList<CarType> findListByBrandId(int brandId) {
		// TODO Auto-generated method stub
		ArrayList<CarType> list = new ArrayList<CarType>();
		//�������ͼ���
		for(CarType carType : carTypeData){
			//���Ʒ����ͬ
			if(carType.getBrandId() == brandId){
				//���������������
				list.add(carType);
			}
		}
		return list;
	}

}
