package com.niit.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.niit.util.CommonUtil;

public class User {
	//用户编号
	private int userId;
	//用户名
	private String userName;
	//密码
	private String password;
	//金额
	private double money;
	//身份
	private boolean isAdmin;
	//收藏的汽车编号  最多10辆
	private ArrayList<Integer> favCars;
	
	
	public User(){}{
		
	}
	/**
	 * 重载带参构造
	 * @param userName
	 * @param password
	 * @param money
	 * @param isAdmin
	 */
	public User(String userName, String password, double money, boolean isAdmin){
		this.userId = CommonUtil.getUserId();
		this.userName = userName;
		this.password = password;
		this.money = money;
		this.isAdmin = isAdmin;
		this.favCars = new ArrayList<Integer>();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public ArrayList<Integer> getFavCars() {
		return favCars;
	}

	public void setFavCars(ArrayList<Integer> favCars) {
		this.favCars = favCars;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
