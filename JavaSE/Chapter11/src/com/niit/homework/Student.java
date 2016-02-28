package com.niit.homework;

public class Student {
	
	private int stuId;
	private String stuName;
	private String className;
	private String gradeName;
	
	public Student(int stuId, String stuName){
		this.stuId = stuId;
		this.stuName = stuName;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
}
