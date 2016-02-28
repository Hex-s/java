package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;

import com.niit.bean.Car;
import com.niit.dao.iface.ICarDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class CarDao implements ICarDao {

	private ArrayList<Car> carData;
	
	public CarDao(Data data){
		this.carData = data.getCarData();
	}
	
	@Override
	public void addCar(Car car) {
		// TODO Auto-generated method stub
		carData.add(car);
	}

	@Override
	public void deleteCarsByTypeId(int typeId) {
		//���ݳ��ͱ�Ų��ҳ���
		ArrayList<Car> list = new ArrayList<Car>();
		//�������г���
		for(Car car : carData){
			//�жϳ��ͱ��
			if(car.getTypeId() == typeId){
				//��������ͬ�ĳ������������
				list.add(car);
			}
		}
		//���ҵ��ĳ�����ɾ��
		carData.removeAll(list);
		
	}

	@Override
	public Car findCarById(int carId) {
		// TODO Auto-generated method stub
		for(Car car : carData){
			if(car.getCarId() == carId){
				return car;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Car> findCarsByPrice(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		ArrayList<Car> list = new ArrayList<Car>();
		for(Car car : carData){
			//�жϳ����۸��Ƿ���������
			if(car.getPrice() >= minPrice && car.getPrice() <= maxPrice){
				//��ӳ���
				list.add(car);
			}
		}
		return list;
	}

	@Override
	public ArrayList<Car> findCarsByTime(Calendar beginTime, Calendar endTime) {
		// TODO Auto-generated method stub
		ArrayList<Car> list = new ArrayList<Car>();
		//������������
		for(Car car : carData){
			//�ж�����ʱ���Ƿ���������
			if(CommonUtil.compareDate(car.getBoardTime(), beginTime) >= 0 && CommonUtil.compareDate(car.getBoardTime(), endTime) <= 0){
				list.add(car);
			}
		}
		return list;
	}

	@Override
	public ArrayList<Car> sortCarsByPublishTime() {
		// TODO Auto-generated method stub
		ArrayList<Car> list = new ArrayList<Car>();
		//����
		for(int i = 1; i < carData.size(); i++){
			for(int j = 0; j < carData.size()-i; j++){
				//����ʱ����бȽ�
				if(carData.get(j).getPublishTime().before(carData.get(j+1).getPublishTime())){
					//�������еĳ������н���
					Car tempCar = carData.get(j);
					carData.set(j, carData.get(j+1));
					carData.set(j+1, tempCar);
				}
			}
		}
		//������
		int count = 0;
		for(Car car : carData){
			if(!car.isSell()){
				//�ۼ�ѭ���Ĵ���
				count++;
				//�������е�Ԫ�������Ҫ��ѯ�ļ�����
				list.add(car);
				//����Ѿ�����10����,�˳�ѭ��
				if(count == 10){
					break;
				}
			}
		}
		return list;
	}

	@Override
	public ArrayList<Car> findCarsByTypeId(int typeId) {
		ArrayList<Car> list = new ArrayList<Car>();
		//�������еĳ���
		for(Car car : carData){
			if(car.getTypeId() == typeId){
				list.add(car);
			}
		}
		return list;
	}
	
	

}
