package com.niit.homework;

import java.util.ArrayList;

public class Class {
	//班级名称
	private String className;
	//班级中的所有学生
	private ArrayList<Student> stuList;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public ArrayList<Student> getStuList() {
		return stuList;
	}
	public void setStuList(ArrayList<Student> stuList) {
		this.stuList = stuList;
	}
	
}
