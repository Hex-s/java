package com.niit.bean;

public class User {
	//�û���
	public String userName;
	//����
	public String password;
	//���
	public double money;
	//���
	public boolean isAdmin;
	//�ղص�������Ϣ
	public int[] favCars;
	
	/**
	 * �û���ʼ��
	 */
	public void init(){
		//��ʼ���ղ���Ϣ
		favCars = new int[10];

	}
}
