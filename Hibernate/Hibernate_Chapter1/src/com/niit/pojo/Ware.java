package com.niit.pojo;
/**
 * 数据表在Java中的实体映射对象
 * @author Administrator
 *
 */
public class Ware {
	//Hibernate中的实体映射对象的属性名可以和数据表的字段名不相同
	private int id;
	private String wareName;
	private double price;
	private int num;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWareName() {
		return wareName;
	}
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
