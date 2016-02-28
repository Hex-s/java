package com.niit.sys;

import java.util.Scanner;

import com.niit.bean.Car;
import com.niit.bean.User;
import com.niit.data.Data;

/**
 * ���ֳ�����ϵͳ
 * @author Administrator
 *
 */
public class UsedCarSystem {
	//������
	Data data;
	//��½�û�
	User loginUser;
	//�Աȳ�������Ϣ
	Car[] compareCar;
	Scanner sc;
	/**
	 * ��ʼ��ϵͳ �������ݿ�
	 * @param data
	 */
	public void init(Data data){
		this.data = data;
		compareCar = new Car[4];
		sc = new Scanner(System.in);
	}
	/**
	 * ����ϵͳ
	 */
	public void start(Data data){
		init(data);
		System.out.println("----------------------NIIT���ֳ�����ƽ̨-----------------------");
		//��ʾ���˵�
		mainMenu();
	}
	/**
	 * ���˵�
	 */
	private void mainMenu(){
		//����û���½�ɹ�����Ҫ��ʾ��½��ע��ѡ��
		if(loginUser == null){
			System.out.println("1. ��½");
			System.out.println("2. ע��");
		}
		System.out.println("3. ���¶��ֳ���Ϣ");
		System.out.println("4. ��������");
		System.out.println("5. �Աȳ���");
		System.out.println("6. �ҵ��ղ�");
		System.out.println("7. ��̨����");
		System.out.println("8. �˳�ϵͳ");
		System.out.println("��ѡ��");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			login();
			break;
		case 2:
			regist();
			break;
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		default:
		}
	}
	/**
	 * ��½
	 */
	private void login() {
		System.out.println("�������û�����");
		String userName = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		//��½�û��������������λ��
		int index;
		//У���û���
		index = validateUserName(userName);
		//�û�������
		if(index != -1){
			if(password.equals(data.userData[index].password)){
				//��½�ɹ�
				System.out.println("��ӭ  "+userName+"  ����");
				//��¼��ǰ��½���û�
				loginUser = data.userData[index];
				//�������˵�
				mainMenu();
			}
			else{
				System.out.println("�����������������");
			}
		}
		else{
			System.out.println("�û��������ڣ����������룡");
		}
	}
	/**
	 * ע��
	 */
	private void regist(){
		System.out.println("�������û���");
		String userName = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		//�ж��û����Ƿ����
		int index = validateUserName(userName);
		//����û��������ڵ�
		if(index == -1){
			//�����µ��û�����
			User user = new User();
			user.init();
			user.userName = userName;
			user.password = password;
			//���������û�д��data
			insertUser(user);
			System.out.println("ע��ɹ���");
			//�������˵�
			mainMenu();
		}
		else{
			System.out.println("�û����Ѿ����ڣ��Ƿ�Ҫ����ע��?");
		}
	}
	/**
	 * У���û����ķ���
	 * @param userName
	 * @return
	 */
	public int validateUserName(String userName){
		//�ж��û����Ƿ����
		for(int i = 0; i < data.userData.length; i++){
			if(data.userData[i] != null){
				//��������û������û������е�ÿһ���û������бȽ�
				if(userName.equals(data.userData[i].userName)){
					return i;
				}
			}
		}
		return -1;
	}
	/**
	 * ���û�д��data�ķ���
	 * @param user
	 */
	public void insertUser(User user){
		for(int i = 0; i < data.userData.length; i++){
			//���������е�һ��Ϊnull��Ԫ��λ�ã���λ�ü�Ҫע��д��������±�
			if(data.userData[i] == null){
				data.userData[i] = user;
				break;
			}
		}
	}
	/**
	 * ����Ʒ�Ʊ�Ų���Ʒ������
	 * @param brandId
	 * @return
	 */
	public String getBrandName(int brandId){
		//����Ʒ������
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				//�жϱ���Ƿ���ͬ
				if(data.brandData[i].brandId == brandId){
					return data.brandData[i].brandName;
				}
			}
		}
		return null;
	}
	/**
	 * ���ݳ��ͱ�Ż�ȡ��������
	 * @param carTypeId
	 * @return
	 */
	public String getCarTypeName(int carTypeId){
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null){
				if(data.carTypeData[i].typeId == carTypeId){
					return data.carTypeData[i].typeName;
				}
			}
		}
		return null;
	}
	/**
	 * ��ȡ���·�����ǰ10��������Ϣ
	 * @return
	 */
	public Car[] getNewPublishCar(){
		//���ݷ���ʱ��Գ�����������
		for(int i = 1; i < data.carData.length; i++){
			for(int j = 0; j < data.carData.length-i; j++){
				if(data.carData[j] != null && data.carData[j+1] != null){
					if(data.carData[j].publishTime.before(data.carData[j+1].publishTime)){
						Car tempCar = data.carData[j];
						data.carData[j] = data.carData[j+1];
						data.carData[j+1] = tempCar;
					}
				}
			}
		}
		Car[] publishCar = new Car[10];
		for(int i = 0; i <= 9; i++){
			publishCar[i] = data.carData[i];
		}
		return publishCar;
	}
}
