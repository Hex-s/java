package com.niit.sys;

import java.util.Scanner;

import com.niit.bean.Car;
import com.niit.bean.User;
import com.niit.data.Data;

/**
 * 二手车管理系统
 * @author Administrator
 *
 */
public class UsedCarSystem {
	//数据类
	Data data;
	//登陆用户
	User loginUser;
	//对比车辆的信息
	Car[] compareCar;
	Scanner sc;
	/**
	 * 初始化系统 传入数据库
	 * @param data
	 */
	public void init(Data data){
		this.data = data;
		compareCar = new Car[4];
		sc = new Scanner(System.in);
	}
	/**
	 * 开启系统
	 */
	public void start(Data data){
		init(data);
		System.out.println("----------------------NIIT二手车交易平台-----------------------");
		//显示主菜单
		mainMenu();
	}
	/**
	 * 主菜单
	 */
	private void mainMenu(){
		//如果用户登陆成功则不需要显示登陆和注册选项
		if(loginUser == null){
			System.out.println("1. 登陆");
			System.out.println("2. 注册");
		}
		System.out.println("3. 最新二手车信息");
		System.out.println("4. 搜索车辆");
		System.out.println("5. 对比车辆");
		System.out.println("6. 我的收藏");
		System.out.println("7. 后台管理");
		System.out.println("8. 退出系统");
		System.out.println("请选择：");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			login();
			break;
		case 2:
			regist();
			break;
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		default:
		}
	}
	/**
	 * 登陆
	 */
	private void login() {
		System.out.println("请输入用户名：");
		String userName = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		//登陆用户所在数组的索引位置
		int index;
		//校验用户名
		index = validateUserName(userName);
		//用户名存在
		if(index != -1){
			if(password.equals(data.userData[index].password)){
				//登陆成功
				System.out.println("欢迎  "+userName+"  回来");
				//记录当前登陆的用户
				loginUser = data.userData[index];
				//返回主菜单
				mainMenu();
			}
			else{
				System.out.println("密码错误！请重新输入");
			}
		}
		else{
			System.out.println("用户名不存在！请重新输入！");
		}
	}
	/**
	 * 注册
	 */
	private void regist(){
		System.out.println("请输入用户名");
		String userName = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		//判断用户名是否存在
		int index = validateUserName(userName);
		//如果用户名不存在的
		if(index == -1){
			//构建新的用户对象
			User user = new User();
			user.init();
			user.userName = userName;
			user.password = password;
			//将创建的用户写入data
			insertUser(user);
			System.out.println("注册成功！");
			//返回主菜单
			mainMenu();
		}
		else{
			System.out.println("用户名已经存在！是否要重新注册?");
		}
	}
	/**
	 * 校验用户名的方法
	 * @param userName
	 * @return
	 */
	public int validateUserName(String userName){
		//判断用户名是否存在
		for(int i = 0; i < data.userData.length; i++){
			if(data.userData[i] != null){
				//将输入的用户名和用户数组中的每一个用户名进行比较
				if(userName.equals(data.userData[i].userName)){
					return i;
				}
			}
		}
		return -1;
	}
	/**
	 * 将用户写入data的方法
	 * @param user
	 */
	public void insertUser(User user){
		for(int i = 0; i < data.userData.length; i++){
			//查找数组中第一次为null的元素位置，该位置即要注册写入的数组下标
			if(data.userData[i] == null){
				data.userData[i] = user;
				break;
			}
		}
	}
	/**
	 * 根据品牌编号查找品牌名称
	 * @param brandId
	 * @return
	 */
	public String getBrandName(int brandId){
		//遍历品牌数组
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				//判断编号是否相同
				if(data.brandData[i].brandId == brandId){
					return data.brandData[i].brandName;
				}
			}
		}
		return null;
	}
	/**
	 * 根据车型编号获取车型名称
	 * @param carTypeId
	 * @return
	 */
	public String getCarTypeName(int carTypeId){
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null){
				if(data.carTypeData[i].typeId == carTypeId){
					return data.carTypeData[i].typeName;
				}
			}
		}
		return null;
	}
	/**
	 * 获取最新发布的前10辆车的信息
	 * @return
	 */
	public Car[] getNewPublishCar(){
		//根据发布时间对车辆进行排序
		for(int i = 1; i < data.carData.length; i++){
			for(int j = 0; j < data.carData.length-i; j++){
				if(data.carData[j] != null && data.carData[j+1] != null){
					if(data.carData[j].publishTime.before(data.carData[j+1].publishTime)){
						Car tempCar = data.carData[j];
						data.carData[j] = data.carData[j+1];
						data.carData[j+1] = tempCar;
					}
				}
			}
		}
		Car[] publishCar = new Car[10];
		for(int i = 0; i <= 9; i++){
			publishCar[i] = data.carData[i];
		}
		return publishCar;
	}
}
