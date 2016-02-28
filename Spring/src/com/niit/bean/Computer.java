package com.niit.bean;

public class Computer implements ITool {
	
	private String cpuName;
	private double price;
	
	public void toolInfo() {
		System.out.println("电脑信息    名称："+cpuName+",价格："+price);
	}

	public String getCpuName() {
		return cpuName;
	}

	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
