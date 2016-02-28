package com.niit.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.niit.util.CommonUtil;

public class User {
	//�û����
	private int userId;
	//�û���
	private String userName;
	//����
	private String password;
	//���
	private double money;
	//���
	private boolean isAdmin;
	//�ղص��������  ���10��
	private ArrayList<Integer> favCars;
	
	
	public User(){}{
		
	}
	/**
	 * ���ش��ι���
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
