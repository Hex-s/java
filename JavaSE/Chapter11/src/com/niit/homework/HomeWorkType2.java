package com.niit.homework;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeWorkType2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建学生信息
		Student stu1 = new Student(1, "A");
		Student stu2 = new Student(2, "B");
		Student stu3 = new Student(3, "C");
		Student stu4 = new Student(4, "D");
		Student stu5 = new Student(5, "E");
		Student stu6 = new Student(6, "F");
		Student stu7 = new Student(7, "G");
		Student stu8 = new Student(8, "H");
		
		//创建班级
		HashMap<String, ArrayList<Student>> class1 = new HashMap<String, ArrayList<Student>>();
		HashMap<String, ArrayList<Student>> class2 = new HashMap<String, ArrayList<Student>>();
		HashMap<String, ArrayList<Student>> class3 = new HashMap<String, ArrayList<Student>>();
		HashMap<String, ArrayList<Student>> class4 = new HashMap<String, ArrayList<Student>>();
		
		//封装第一个班级的学生集合
		ArrayList<Student> stuList1 = new ArrayList<Student>();
		ArrayList<Student> stuList2 = new ArrayList<Student>();
		ArrayList<Student> stuList3 = new ArrayList<Student>();
		ArrayList<Student> stuList4 = new ArrayList<Student>();
		
		//添加第一个班级的学生
		stuList1.add(stu1);
		stuList1.add(stu2);
		//添加第二个班级的学生
		stuList2.add(stu3);
		stuList2.add(stu4);
		//添加第三个班级的学生
		stuList3.add(stu5);
		stuList3.add(stu6);
		//添加第四个班级的学生
		stuList4.add(stu7);
		stuList4.add(stu8);
		
		//将学生集合添加至第一个班级
		class1.put("班级A", stuList1);
		//将学生集合添加至第二个班级
		class2.put("班级B", stuList2);
		//将学生集合添加至第三个班级
		class3.put("班级C", stuList3);
		//将学生集合添加至第四个班级
		class4.put("班级D", stuList4);
		
		//创建2个年级
		HashMap<String, ArrayList<HashMap<String, ArrayList<Student>>>> grade1 = new HashMap<String, ArrayList<HashMap<String,ArrayList<Student>>>>();
		HashMap<String, ArrayList<HashMap<String, ArrayList<Student>>>> grade2 = new HashMap<String, ArrayList<HashMap<String,ArrayList<Student>>>>();
		
		//创建一年级对应的班级集合
		ArrayList<HashMap<String, ArrayList<Student>>> classesInGrade1 = new ArrayList<HashMap<String,ArrayList<Student>>>();
		//将1,2班添加至班级集合
		classesInGrade1.add(class1);
		classesInGrade1.add(class2);
		//将1,2班级的集合添加至第一个年级
		grade1.put("一年级", classesInGrade1);
		
		//创建二年级对应的班级集合
		ArrayList<HashMap<String, ArrayList<Student>>> classesInGrade2 = new ArrayList<HashMap<String,ArrayList<Student>>>();
		//将3,4班添加至班级集合
		classesInGrade2.add(class3);
		classesInGrade2.add(class4);
		//将3,4班级的集合添加至第二个年级
		grade2.put("二年级", classesInGrade2);
		
		//构建学校集合用来存储所有的年级
		ArrayList<HashMap<String, ArrayList<HashMap<String, ArrayList<Student>>>>> schoolList = new ArrayList<HashMap<String,ArrayList<HashMap<String,ArrayList<Student>>>>>();
		//将年级添加至学校
		schoolList.add(grade1);
		schoolList.add(grade2);
		
		//遍历学校集合
		for(HashMap<String, ArrayList<HashMap<String, ArrayList<Student>>>> grade : schoolList){
			//遍历没一个年级
			for(String gradeName : grade.keySet()){
				//显示年级名称
				System.out.println(gradeName);
				//根据键获取值（根据年级名称获取班级集合）
				ArrayList<HashMap<String, ArrayList<Student>>> classList = grade.get(gradeName);
				//遍历班级
				for(HashMap<String, ArrayList<Student>> clazz : classList){
					//此时一个HashMap对应的是一个班级，虽然只有一个元素，要获取班级信息还是需要通过遍历来获取
					for(String className : clazz.keySet()){
						//显示班级名称
						System.out.println("\t"+className);
						//根据班级名称获取班级中的学生集合
						ArrayList<Student> stuList = clazz.get(className);
						//遍历学生集合
						for(Student stu : stuList){
							System.out.println("\t\t"+stu.getStuId()+"\t"+stu.getStuName());
						}
					}
				}
			}
		}
	
		
	}

}
