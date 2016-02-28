package com.niit.homework;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeWork {

	public static void main(String[] args) {
		
		//创建年级的集合
		ArrayList<Grade> gradeList = new ArrayList<Grade>();
		
		//创建班级的集合
		ArrayList<Class> classList1 = new ArrayList<Class>();
		ArrayList<Class> classList2 = new ArrayList<Class>();
		
		//创建每个班级中学生的集合
		ArrayList<Student> stuList1 = new ArrayList<Student>();
		ArrayList<Student> stuList2 = new ArrayList<Student>();
		ArrayList<Student> stuList3= new ArrayList<Student>();
		ArrayList<Student> stuList4 = new ArrayList<Student>();
		
		//创建年级信息
		Grade grade1 = new Grade();
		grade1.setGradeName("一年级");
		Grade grade2 = new Grade();
		grade2.setGradeName("二年级");
		
		//创建班级信息
		Class class1 = new Class();
		class1.setClassName("班级A");
		Class class2 = new Class();
		class2.setClassName("班级B");
		Class class3 = new Class();
		class3.setClassName("班级C");
		Class class4 = new Class();
		class4.setClassName("班级D");
		
		//创建学生的信息
		Student stu1 = new Student(1, "A");
		Student stu2 = new Student(2, "B");
		Student stu3 = new Student(3, "C");
		Student stu4 = new Student(4, "D");
		Student stu5 = new Student(5, "E");
		Student stu6 = new Student(6, "F");
		Student stu7 = new Student(7, "G");
		Student stu8 = new Student(8, "H");
		
		//将学生分别添加至各个学生集合中
		stuList1.add(stu1);
		stuList1.add(stu2);
		
		stuList2.add(stu3);
		stuList2.add(stu4);
		
		stuList3.add(stu5);
		stuList3.add(stu6);
		
		stuList4.add(stu7);
		stuList4.add(stu8);
		
		//将学生添加至班级中
		class1.setStuList(stuList1);
		class2.setStuList(stuList2);
		class3.setStuList(stuList3);
		class4.setStuList(stuList4);
		
		//将班级添加至年级
		classList1.add(class1);
		classList1.add(class2);
		classList2.add(class3);
		classList2.add(class4);
		
		grade1.setClassList(classList1);
		grade2.setClassList(classList2);
		
		//将年级添加至年级集合
		gradeList.add(grade1);
		gradeList.add(grade2);
		
		//遍历年级集合
		for(Grade grade : gradeList){
			System.out.println(grade.getGradeName());
			//遍历年级中的班级集合
			for(Class clazz : grade.getClassList()){
				System.out.println("\t"+clazz.getClassName());
				//遍历班级中学生的集合
				for(Student stu : clazz.getStuList()){
					System.out.println("\t\t"+stu.getStuId()+"\t"+stu.getStuName());
				}
			}
		}
		
		
		
	}
}
