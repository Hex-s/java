package com.niit.pojo;

import java.util.Set;

public class Student {
	private int stuId;
	private String stuName;
	//������������������Ӧ�����ɶ���
	private Teacher teacher;
	//һ��һӳ��
	private Card card;
	//��Զ�ӳ����Ӽ���
	private Set<Teacher> teacherSet;
	
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Set<Teacher> getTeacherSet() {
		return teacherSet;
	}
	public void setTeacherSet(Set<Teacher> teacherSet) {
		this.teacherSet = teacherSet;
	}
	
}
