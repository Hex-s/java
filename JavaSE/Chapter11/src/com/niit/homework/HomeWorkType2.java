package com.niit.homework;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeWorkType2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����ѧ����Ϣ
		Student stu1 = new Student(1, "A");
		Student stu2 = new Student(2, "B");
		Student stu3 = new Student(3, "C");
		Student stu4 = new Student(4, "D");
		Student stu5 = new Student(5, "E");
		Student stu6 = new Student(6, "F");
		Student stu7 = new Student(7, "G");
		Student stu8 = new Student(8, "H");
		
		//�����༶
		HashMap<String, ArrayList<Student>> class1 = new HashMap<String, ArrayList<Student>>();
		HashMap<String, ArrayList<Student>> class2 = new HashMap<String, ArrayList<Student>>();
		HashMap<String, ArrayList<Student>> class3 = new HashMap<String, ArrayList<Student>>();
		HashMap<String, ArrayList<Student>> class4 = new HashMap<String, ArrayList<Student>>();
		
		//��װ��һ���༶��ѧ������
		ArrayList<Student> stuList1 = new ArrayList<Student>();
		ArrayList<Student> stuList2 = new ArrayList<Student>();
		ArrayList<Student> stuList3 = new ArrayList<Student>();
		ArrayList<Student> stuList4 = new ArrayList<Student>();
		
		//��ӵ�һ���༶��ѧ��
		stuList1.add(stu1);
		stuList1.add(stu2);
		//��ӵڶ����༶��ѧ��
		stuList2.add(stu3);
		stuList2.add(stu4);
		//��ӵ������༶��ѧ��
		stuList3.add(stu5);
		stuList3.add(stu6);
		//��ӵ��ĸ��༶��ѧ��
		stuList4.add(stu7);
		stuList4.add(stu8);
		
		//��ѧ�������������һ���༶
		class1.put("�༶A", stuList1);
		//��ѧ������������ڶ����༶
		class2.put("�༶B", stuList2);
		//��ѧ������������������༶
		class3.put("�༶C", stuList3);
		//��ѧ��������������ĸ��༶
		class4.put("�༶D", stuList4);
		
		//����2���꼶
		HashMap<String, ArrayList<HashMap<String, ArrayList<Student>>>> grade1 = new HashMap<String, ArrayList<HashMap<String,ArrayList<Student>>>>();
		HashMap<String, ArrayList<HashMap<String, ArrayList<Student>>>> grade2 = new HashMap<String, ArrayList<HashMap<String,ArrayList<Student>>>>();
		
		//����һ�꼶��Ӧ�İ༶����
		ArrayList<HashMap<String, ArrayList<Student>>> classesInGrade1 = new ArrayList<HashMap<String,ArrayList<Student>>>();
		//��1,2��������༶����
		classesInGrade1.add(class1);
		classesInGrade1.add(class2);
		//��1,2�༶�ļ����������һ���꼶
		grade1.put("һ�꼶", classesInGrade1);
		
		//�������꼶��Ӧ�İ༶����
		ArrayList<HashMap<String, ArrayList<Student>>> classesInGrade2 = new ArrayList<HashMap<String,ArrayList<Student>>>();
		//��3,4��������༶����
		classesInGrade2.add(class3);
		classesInGrade2.add(class4);
		//��3,4�༶�ļ���������ڶ����꼶
		grade2.put("���꼶", classesInGrade2);
		
		//����ѧУ���������洢���е��꼶
		ArrayList<HashMap<String, ArrayList<HashMap<String, ArrayList<Student>>>>> schoolList = new ArrayList<HashMap<String,ArrayList<HashMap<String,ArrayList<Student>>>>>();
		//���꼶�����ѧУ
		schoolList.add(grade1);
		schoolList.add(grade2);
		
		//����ѧУ����
		for(HashMap<String, ArrayList<HashMap<String, ArrayList<Student>>>> grade : schoolList){
			//����ûһ���꼶
			for(String gradeName : grade.keySet()){
				//��ʾ�꼶����
				System.out.println(gradeName);
				//���ݼ���ȡֵ�������꼶���ƻ�ȡ�༶���ϣ�
				ArrayList<HashMap<String, ArrayList<Student>>> classList = grade.get(gradeName);
				//�����༶
				for(HashMap<String, ArrayList<Student>> clazz : classList){
					//��ʱһ��HashMap��Ӧ����һ���༶����Ȼֻ��һ��Ԫ�أ�Ҫ��ȡ�༶��Ϣ������Ҫͨ����������ȡ
					for(String className : clazz.keySet()){
						//��ʾ�༶����
						System.out.println("\t"+className);
						//���ݰ༶���ƻ�ȡ�༶�е�ѧ������
						ArrayList<Student> stuList = clazz.get(className);
						//����ѧ������
						for(Student stu : stuList){
							System.out.println("\t\t"+stu.getStuId()+"\t"+stu.getStuName());
						}
					}
				}
			}
		}
	
		
	}

}
