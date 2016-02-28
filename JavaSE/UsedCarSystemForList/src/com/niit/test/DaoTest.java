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
	 * 每一个DAO对象写完后都应进行测试
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
//		//添加数据
//		userDao.add(user);
//		
//		//根据编号查找
//		User searchUser = userDao.findUserById(1);
//		//如果是查找方法则必须要对返回值进行判断
//		if(searchUser != null){
//			System.out.println(searchUser.getUserId()+"\t"+searchUser.getUserName()+"\t"+searchUser.getPassword());
//			searchUser.setPassword("456");
//			//修改用户数据
//			userDao.modify(1, searchUser);
//		}
//		
//		
//		//获取所有的用户数据
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
