package com.niit.bean;

import java.util.Calendar;

import javax.swing.border.Border;

import com.niit.util.CommonUtil;

public class Car {
	//汽车编号
	private int carId;
	//车型编号
	private int typeId;
	//排量
	private String displacement;
	//里程数
	private long distance;
	//价格
	private double price;
	//离合器类型
	private String cluthType;
	//上牌时间
	private Calendar boardTime;
	//发布时间
	private Calendar publishTime;
	//购买标识
	private boolean isSell;
	
	public Car(int typeId, String displacement, long distance, double price, String cluthType, Calendar boardTime, Calendar publishTime, boolean isSell){
		this.carId = CommonUtil.getCarId();
		this.typeId = typeId;
		this.displacement = displacement;
		this.distance = distance;
		this.price = price;
		this.cluthType = cluthType;
		this.boardTime = boardTime;
		this.publishTime = publishTime;
		this.isSell = isSell;
	}
	public Car(){
		
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getDisplacement() {
		return displacement;
	}
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCluthType() {
		return cluthType;
	}
	public void setCluthType(String cluthType) {
		this.cluthType = cluthType;
	}
	public Calendar getBoardTime() {
		return boardTime;
	}
	public void setBoardTime(Calendar boardTime) {
		this.boardTime = boardTime;
	}
	public Calendar getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Calendar publishTime) {
		this.publishTime = publishTime;
	}
	public boolean isSell() {
		return isSell;
	}
	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}
	
}
