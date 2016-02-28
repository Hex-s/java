package com.niit.test;

import java.util.ArrayList;
import java.util.List;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.User;
import com.niit.dao.impl.BrandDao;
import com.niit.dao.impl.CarDao;
import com.niit.dao.impl.CompareCarDao;
import com.niit.dao.impl.UserDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class DaoTest {

	/**
	 * ÿһ��DAO����д���Ӧ���в���
	 * @param args
	 */
	public static void main(String[] args) {
		
		Data data = new Data();
		
//		UserDao userDao = new UserDao(data);
//		User user = new User();
//		user.setUserId(1);
//		user.setUserName("jack");
//		user.setPassword("123");
//		user.setMoney(1000);
//		//�������
//		userDao.add(user);
//		
//		//���ݱ�Ų���
//		User searchUser = userDao.findUserById(1);
//		//����ǲ��ҷ��������Ҫ�Է���ֵ�����ж�
//		if(searchUser != null){
//			System.out.println(searchUser.getUserId()+"\t"+searchUser.getUserName()+"\t"+searchUser.getPassword());
//			searchUser.setPassword("456");
//			//�޸��û�����
//			userDao.modify(1, searchUser);
//		}
//		
//		
//		//��ȡ���е��û�����
//		List<User> list = userDao.findAll();
//		for(User u : list){
//			System.out.println(u.getUserId()+"\t"+u.getUserName()+"\t"+u.getPassword());
//		}
		
//		CarDao carDao = new CarDao(data);
//		ArrayList<Car> list = carDao.sortCarsByPublishTime();
//		
//		for(Car car : list){
//			System.out.println(car.getCarId()+"\t"+CommonUtil.formatDate(car.getPublishTime()));
//		}
		
		CompareCarDao dao = new CompareCarDao(data);
		dao.addCompareCar(1, 1);
		
		
	}

}
