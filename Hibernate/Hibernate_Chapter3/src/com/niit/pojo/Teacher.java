package com.niit.pojo;

import java.util.List;
import java.util.Set;

public class Teacher {
	private int teacherId;
	private String teacherName;
	//一对多关系  通过集合描述
	private Set<Student> stuSet;
	//多对多关系 
	private List<Student> stuList;
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Set<Student> getStuSet() {
		return stuSet;
	}
	public void setStuSet(Set<Student> stuSet) {
		this.stuSet = stuSet;
	}
	public List<Student> getStuList() {
		return stuList;
	}
	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	
}
