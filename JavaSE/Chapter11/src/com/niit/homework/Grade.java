package com.niit.homework;

import java.util.ArrayList;

public class Grade {
	//年级名称
	private String gradeName;
	//年级中的班级集合
	private ArrayList<Class> classList;
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public ArrayList<Class> getClassList() {
		return classList;
	}
	public void setClassList(ArrayList<Class> classList) {
		this.classList = classList;
	}
	
}
