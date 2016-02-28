package com.niit.logic;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.dao.impl.BrandDao;
import com.niit.dao.impl.CarDao;
import com.niit.dao.impl.CarTypeDao;
import com.niit.dao.impl.CompareCarDao;
import com.niit.dao.impl.UserDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class CarSystem {

	//创建业务需要访问的DAO对象
	private UserDao userDao;
	private CarDao carDao;
	private CarTypeDao carTypeDao;
	private BrandDao brandDao;
	private CompareCarDao compareDao;
	//登陆的用户
	private User loginUser;
	
	private Scanner sc;
	
	/**
	 * 初始化
	 * @param data
	 */
	public CarSystem(Data data){
		//创建DAO对象
		userDao = new UserDao(data);
		carDao = new CarDao(data);
		carTypeDao = new CarTypeDao(data);
		brandDao = new BrandDao(data);
		compareDao = new CompareCarDao(data);
		sc = new Scanner(System.in);
	}
	public void start(){		
		System.out.println("1. 登陆");
		System.out.println("2. 注册");
		System.out.println("3. 最新二手车信息");
		System.out.println("4. 搜索车辆");
		System.out.println("5. 对比车辆");
		System.out.println("6. 我的收藏");
		System.out.println("7. 后台管理");
		System.out.println("8. 注销用户");
		System.out.println("9. 退出系统");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			login();
			break;
		case 2:
			break;
		case 3:
			searchNewCars();
			break;
		case 4:
			searchMenu();
			break;
		case 5:
			compareCarMenu();
			break;
		case 6:
			myFavCar();
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		}
	}
	/**
	 * 我的收藏
	 */
	private void myFavCar() {
		//根据登陆人的编号查询收藏的车辆集合
		ArrayList<Integer> list = loginUser.getFavCars();
		int i = 0;
		//遍历收藏的汽车编号
		for(Integer carId : list){
			//根据编号查询车辆
			Car car = carDao.findCarById(carId);
			//打印车辆基本信息信息
			printCarInfo(car, i, false);
			i++;
		}
		System.out.println("请选择：");
		int index = sc.nextInt();
		//获取选择的车辆
		Car car = carDao.findCarById(list.get(index-1));
		//打印选择车辆的详细信息
		printCarInfo(car, 0, true);
		//车辆操作菜单
		carMenu(car);
		
	}
	/**
	 * 登陆
	 */
	private void login(){
		System.out.println("请输入用户名：");
		String userName = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		//根据用户名查找对象
		User user = userDao.findUserByName(userName);
		//判断对象是否存在
		if(user != null){
			//判断密码
			if(user.getPassword().equals(password)){
				System.out.println("登陆成功");
				//保存登陆的用户
				loginUser = user;
				//跳转回主菜单
				start();
			}
			else{
				System.out.println("密码错误");
			}
		}
		else{
			System.out.println("用户名不存在");
		}
	}
	/**
	 * 最新二手车
	 */
	private void searchNewCars(){
		//查找最新二手车信息
		ArrayList<Car> list = carDao.sortCarsByPublishTime();
		//显示车辆信息
		for(int i = 0; i < list.size(); i++){
			//获取每辆车
			Car car = list.get(i);
			printCarInfo(car, i, true);
		}
		System.out.println("请选择：");
		//获取选择项，选择项用来在查找的集合中获取对应的元素
		int index = sc.nextInt();
		//根据选项获取选中车辆的详细信息
		Car car = list.get(index-1);
		//打印详细信息
		printCarInfo(car, 0, true);
		//进入车辆选择菜单
		carMenu(car);
	} 
	/**
	 * 车辆操作菜单
	 */
	private void carMenu(Car car){
		System.out.println("1. 收藏");
		System.out.println("2. 加入对比");
		System.out.println("3. 购买");
		System.out.println("4. 返回主菜单");
		System.out.println("请选择：");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			addFavCar(car);
			break;
		case 2:
			addCompareCar(car);
			break;
		case 3:
			buyCar(car);
			break;
		case 4:
			start();
			break;
		}
	}
	/**
	 * 收藏车辆
	 * @param car
	 */
	private void addFavCar(Car car){
		//判断用户是否收藏满10辆车
		if(loginUser.getFavCars().size() == 10){
			//车辆如果已满，删除收藏列表的第一辆车辆信息
			loginUser.getFavCars().remove(0);
		}
		//判断车辆是否已被收藏过
		if(loginUser.getFavCars().contains(car.getCarId())){
			System.out.println("该车已在收藏列表中，不能重复收藏！");
			//菜单跳转回车辆操作菜单
			carMenu(car);
			return;
		}
		//将现在要收藏的车辆添加至列表
		loginUser.getFavCars().add(car.getCarId());
		//将修改后的用户修改回Data
		userDao.modify(loginUser.getUserId(), loginUser);
		System.out.println("成功收藏车辆！");
		//菜单跳转回车辆操作菜单
		carMenu(car);
	}
	
	/**
	 * 加入对比
	 * @param car
	 */
	private void addCompareCar(Car car){
		//获取登陆人的对比车辆信息
		ArrayList<Integer> list = compareDao.findCarsByUserId(loginUser.getUserId());
		//判断登陆人的对比车辆是否有重复
		if(list.contains(car.getCarId())){
			System.out.println("对比车辆存在重复！");
			//返回车辆操作菜单
			carMenu(car);
			return;
		}
		//不重复就加入对比集合
		compareDao.addCompareCar(loginUser.getUserId(), car.getCarId());
		System.out.println("成功加入对比！");
		//返回车辆操作菜单
		carMenu(car);
	}
	/**
	 * 加入对比菜单
	 * @param car
	 */
	private void compareCarMenu(){
		System.out.println("1. 查看对比信息");
		System.out.println("2. 删除对比车辆");
		System.out.println("3. 返回上一级菜单");
		System.out.println("请选择：");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			showCompareCarInfo();
			break;
		case 2:
			deleteCompareCar();
			break;
		case 3:
			start();
			break;
		}
	}
	/**
	 * 查看对比信息
	 */
	private void showCompareCarInfo(){
		System.out.println("------------------对比车辆-------------------");
		//根据登录人的编号查找对比车辆集合
		ArrayList<Integer> list = compareDao.findCarsByUserId(loginUser.getUserId());
		int i = 0;
		//显示对比的车辆信息
		for(Integer carId : list){
			//根据车辆编号查询车辆
			Car car = carDao.findCarById(carId);
			//打印车辆的详细信息进行对比
			printCarInfo(car, i, true);
			i++;
		}
		//返回对比菜单
		compareCarMenu();
	}
	/**
	 * 删除对比车辆
	 */
	private void deleteCompareCar(){
		
	}
	/**
	 * 购买车辆
	 * @param car
	 */
	private void buyCar(Car car){
		
	}
	/**
	 * 搜索车辆菜单
	 */
	private void searchMenu(){
		System.out.println("1. 根据品牌搜索");
		System.out.println("2. 根据价格搜索");
		System.out.println("3. 根据上牌日期搜索");
		System.out.println("4. 返回主菜单");
		System.out.println("请选择：");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			searchByBrand();
			break;
		case 2:
			searchByPrice();
			break;
		case 3:
			searchByTime();
			break;
		case 4:
			start();
			break;
		}
	}
	/**
	 * 根据上牌日期搜索车辆
	 */
	private void searchByTime() {
		System.out.println("请输入搜索的起始日期(yyyy-MM-dd)");
		String begin = sc.next();
		//构建正则表达式的匹配规则
		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		//根据规则创建匹配器
		Matcher matcher = pattern.matcher(begin);
		//校验输入的日期是否合法
		if(matcher.matches()){
			System.out.println("请输入搜索的结束日期(yyyy-MM-dd)");
			String end = sc.next();
			matcher = pattern.matcher(end);
			//匹配是否合法
			if(matcher.matches()){
				//将输入起始时间和结束时间转换成Calendar类型
				DateFormat format = DateFormat.getDateInstance();
				Date beginDate = null;
				Date endDate = null;
				try {
					//先将字符串时间转换成Date类型
					beginDate = format.parse(begin);
					endDate = format.parse(end);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//将Date类型转换成Calendar类型
				Calendar beginTime = Calendar.getInstance();
				beginTime.setTime(beginDate);
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(endDate);
				//打印测试
//				System.out.println(CommonUtil.formatDate(beginTime));
//				System.out.println(CommonUtil.formatDate(endTime));
				//根据输入的起始和结束时间进行查询
				ArrayList<Car> list = carDao.findCarsByTime(beginTime, endTime);
				int i = 0;
				//遍历集合
				for(Car car : list){
					//打印车辆信息
					printCarInfo(car, i, true);
					i++;
				}
				System.out.println("请选择车辆：");
				int index = sc.nextInt();
				//根据选择获取车辆对象
				Car car = list.get(index-1);
				//打印详细信息
				printCarInfo(car, 0, true);
				//显示车辆操作菜单
				carMenu(car);	
			}
			else{
				System.out.println("结束日期输入非法！");
			}
		}
		else{
			System.out.println("起始日期输入非法！");
			searchByTime();
		}
		
	}
	/**
	 * 根据价格搜索车辆
	 */
	private void searchByPrice() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 根据品牌搜索车辆
	 */
	private void searchByBrand() {
		//查询所有品牌
		ArrayList<Brand> list = brandDao.findAll();
		int i = 0;
		//遍历打印品牌
		for(Brand brand : list){
			System.out.println(i+1+".\t"+brand.getBrandName());
			i++;
		}
		System.out.println("请选择品牌：");
		int index = sc.nextInt();
		//根据选择获取品牌
		Brand brand = list.get(index-1);
		//根据品牌编号查询车型
		ArrayList<CarType> typeList = carTypeDao.findListByBrandId(brand.getBrandId());
		//构建集合存储根据车型查到的所有车辆
		ArrayList<Car> carList = new ArrayList<Car>();
		//打印的序列
		i = 0;
		//遍历车型集合
		for(CarType type : typeList){
			//根据车型编号查找车辆对象
			ArrayList<Car> searchList = carDao.findCarsByTypeId(type.getTypeId());
			//遍历找到的车辆，并将多个集合中的车辆归纳在carList中
			for(Car car : searchList){
				carList.add(car);
				//打印车辆的信息
				printCarInfo(car, i, false);
				i++;
			}
		}
		System.out.println("请选择车辆：");
		index = sc.nextInt();
		//获取选中的车辆
		Car car = carList.get(index-1);
		//打印车辆的详细信息
		printCarInfo(car, 0, true);
		//显示车辆操作菜单
		carMenu(car);
		
	}
	/**
	 * 打印车辆信息的方法
	 * @param car 
	 * @param i 打印的序列
	 * @param flag true表示需要打印详细信息  false打印简略的信息
	 */
	private void printCarInfo(Car car, int i, boolean flag){
		//构建缓冲字符串
		StringBuffer str = new StringBuffer();
		//根据车辆的车型编号获取车型对象
		CarType carType = carTypeDao.findCarTypeById(car.getTypeId());
		//根据车型对象中的品牌编号获取品牌对象
		Brand brand = brandDao.findBrandById(carType.getBrandId());
		if(flag){
			str.append(i+1+"\t");
			str.append(brand.getBrandName()+"\t");
			str.append(carType.getTypeName()+"\t");
			str.append(car.getPrice()+"\t");
			str.append(car.getDistance()+"\t");
			str.append(car.getDisplacement()+"\t");
			str.append(car.getCluthType()+"\t");
			str.append(CommonUtil.formatDate(car.getPublishTime())+"\t");
			str.append(CommonUtil.formatDate(car.getBoardTime()));
			
			System.out.println(str);
		}
		else{
			str.append(i+1+"\t");
			str.append(brand.getBrandName()+"\t");
			str.append(carType.getTypeName()+"\t");
			str.append(car.getPrice()+"\t");
			str.append(car.getDistance()+"\t");
			str.append(CommonUtil.formatDate(car.getPublishTime()));
			System.out.println(str);
		}
	}
}
