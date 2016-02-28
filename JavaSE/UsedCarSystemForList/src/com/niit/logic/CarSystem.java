package com.niit.logic;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.dao.impl.BrandDao;
import com.niit.dao.impl.CarDao;
import com.niit.dao.impl.CarTypeDao;
import com.niit.dao.impl.CompareCarDao;
import com.niit.dao.impl.UserDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class CarSystem {

	//����ҵ����Ҫ���ʵ�DAO����
	private UserDao userDao;
	private CarDao carDao;
	private CarTypeDao carTypeDao;
	private BrandDao brandDao;
	private CompareCarDao compareDao;
	//��½���û�
	private User loginUser;
	
	private Scanner sc;
	
	/**
	 * ��ʼ��
	 * @param data
	 */
	public CarSystem(Data data){
		//����DAO����
		userDao = new UserDao(data);
		carDao = new CarDao(data);
		carTypeDao = new CarTypeDao(data);
		brandDao = new BrandDao(data);
		compareDao = new CompareCarDao(data);
		sc = new Scanner(System.in);
	}
	public void start(){		
		System.out.println("1. ��½");
		System.out.println("2. ע��");
		System.out.println("3. ���¶��ֳ���Ϣ");
		System.out.println("4. ��������");
		System.out.println("5. �Աȳ���");
		System.out.println("6. �ҵ��ղ�");
		System.out.println("7. ��̨����");
		System.out.println("8. ע���û�");
		System.out.println("9. �˳�ϵͳ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			login();
			break;
		case 2:
			break;
		case 3:
			searchNewCars();
			break;
		case 4:
			searchMenu();
			break;
		case 5:
			compareCarMenu();
			break;
		case 6:
			myFavCar();
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		}
	}
	/**
	 * �ҵ��ղ�
	 */
	private void myFavCar() {
		//���ݵ�½�˵ı�Ų�ѯ�ղصĳ�������
		ArrayList<Integer> list = loginUser.getFavCars();
		int i = 0;
		//�����ղص��������
		for(Integer carId : list){
			//���ݱ�Ų�ѯ����
			Car car = carDao.findCarById(carId);
			//��ӡ����������Ϣ��Ϣ
			printCarInfo(car, i, false);
			i++;
		}
		System.out.println("��ѡ��");
		int index = sc.nextInt();
		//��ȡѡ��ĳ���
		Car car = carDao.findCarById(list.get(index-1));
		//��ӡѡ��������ϸ��Ϣ
		printCarInfo(car, 0, true);
		//���������˵�
		carMenu(car);
		
	}
	/**
	 * ��½
	 */
	private void login(){
		System.out.println("�������û�����");
		String userName = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		//�����û������Ҷ���
		User user = userDao.findUserByName(userName);
		//�ж϶����Ƿ����
		if(user != null){
			//�ж�����
			if(user.getPassword().equals(password)){
				System.out.println("��½�ɹ�");
				//�����½���û�
				loginUser = user;
				//��ת�����˵�
				start();
			}
			else{
				System.out.println("�������");
			}
		}
		else{
			System.out.println("�û���������");
		}
	}
	/**
	 * ���¶��ֳ�
	 */
	private void searchNewCars(){
		//�������¶��ֳ���Ϣ
		ArrayList<Car> list = carDao.sortCarsByPublishTime();
		//��ʾ������Ϣ
		for(int i = 0; i < list.size(); i++){
			//��ȡÿ����
			Car car = list.get(i);
			printCarInfo(car, i, true);
		}
		System.out.println("��ѡ��");
		//��ȡѡ���ѡ���������ڲ��ҵļ����л�ȡ��Ӧ��Ԫ��
		int index = sc.nextInt();
		//����ѡ���ȡѡ�г�������ϸ��Ϣ
		Car car = list.get(index-1);
		//��ӡ��ϸ��Ϣ
		printCarInfo(car, 0, true);
		//���복��ѡ��˵�
		carMenu(car);
	} 
	/**
	 * ���������˵�
	 */
	private void carMenu(Car car){
		System.out.println("1. �ղ�");
		System.out.println("2. ����Ա�");
		System.out.println("3. ����");
		System.out.println("4. �������˵�");
		System.out.println("��ѡ��");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			addFavCar(car);
			break;
		case 2:
			addCompareCar(car);
			break;
		case 3:
			buyCar(car);
			break;
		case 4:
			start();
			break;
		}
	}
	/**
	 * �ղس���
	 * @param car
	 */
	private void addFavCar(Car car){
		//�ж��û��Ƿ��ղ���10����
		if(loginUser.getFavCars().size() == 10){
			//�������������ɾ���ղ��б�ĵ�һ��������Ϣ
			loginUser.getFavCars().remove(0);
		}
		//�жϳ����Ƿ��ѱ��ղع�
		if(loginUser.getFavCars().contains(car.getCarId())){
			System.out.println("�ó������ղ��б��У������ظ��ղأ�");
			//�˵���ת�س��������˵�
			carMenu(car);
			return;
		}
		//������Ҫ�ղصĳ���������б�
		loginUser.getFavCars().add(car.getCarId());
		//���޸ĺ���û��޸Ļ�Data
		userDao.modify(loginUser.getUserId(), loginUser);
		System.out.println("�ɹ��ղس�����");
		//�˵���ת�س��������˵�
		carMenu(car);
	}
	
	/**
	 * ����Ա�
	 * @param car
	 */
	private void addCompareCar(Car car){
		//��ȡ��½�˵ĶԱȳ�����Ϣ
		ArrayList<Integer> list = compareDao.findCarsByUserId(loginUser.getUserId());
		//�жϵ�½�˵ĶԱȳ����Ƿ����ظ�
		if(list.contains(car.getCarId())){
			System.out.println("�Աȳ��������ظ���");
			//���س��������˵�
			carMenu(car);
			return;
		}
		//���ظ��ͼ���Աȼ���
		compareDao.addCompareCar(loginUser.getUserId(), car.getCarId());
		System.out.println("�ɹ�����Աȣ�");
		//���س��������˵�
		carMenu(car);
	}
	/**
	 * ����ԱȲ˵�
	 * @param car
	 */
	private void compareCarMenu(){
		System.out.println("1. �鿴�Ա���Ϣ");
		System.out.println("2. ɾ���Աȳ���");
		System.out.println("3. ������һ���˵�");
		System.out.println("��ѡ��");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			showCompareCarInfo();
			break;
		case 2:
			deleteCompareCar();
			break;
		case 3:
			start();
			break;
		}
	}
	/**
	 * �鿴�Ա���Ϣ
	 */
	private void showCompareCarInfo(){
		System.out.println("------------------�Աȳ���-------------------");
		//���ݵ�¼�˵ı�Ų��ҶԱȳ�������
		ArrayList<Integer> list = compareDao.findCarsByUserId(loginUser.getUserId());
		int i = 0;
		//��ʾ�Աȵĳ�����Ϣ
		for(Integer carId : list){
			//���ݳ�����Ų�ѯ����
			Car car = carDao.findCarById(carId);
			//��ӡ��������ϸ��Ϣ���жԱ�
			printCarInfo(car, i, true);
			i++;
		}
		//���ضԱȲ˵�
		compareCarMenu();
	}
	/**
	 * ɾ���Աȳ���
	 */
	private void deleteCompareCar(){
		
	}
	/**
	 * ������
	 * @param car
	 */
	private void buyCar(Car car){
		
	}
	/**
	 * ���������˵�
	 */
	private void searchMenu(){
		System.out.println("1. ����Ʒ������");
		System.out.println("2. ���ݼ۸�����");
		System.out.println("3. ����������������");
		System.out.println("4. �������˵�");
		System.out.println("��ѡ��");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			searchByBrand();
			break;
		case 2:
			searchByPrice();
			break;
		case 3:
			searchByTime();
			break;
		case 4:
			start();
			break;
		}
	}
	/**
	 * ��������������������
	 */
	private void searchByTime() {
		System.out.println("��������������ʼ����(yyyy-MM-dd)");
		String begin = sc.next();
		//����������ʽ��ƥ�����
		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		//���ݹ��򴴽�ƥ����
		Matcher matcher = pattern.matcher(begin);
		//У������������Ƿ�Ϸ�
		if(matcher.matches()){
			System.out.println("�����������Ľ�������(yyyy-MM-dd)");
			String end = sc.next();
			matcher = pattern.matcher(end);
			//ƥ���Ƿ�Ϸ�
			if(matcher.matches()){
				//��������ʼʱ��ͽ���ʱ��ת����Calendar����
				DateFormat format = DateFormat.getDateInstance();
				Date beginDate = null;
				Date endDate = null;
				try {
					//�Ƚ��ַ���ʱ��ת����Date����
					beginDate = format.parse(begin);
					endDate = format.parse(end);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//��Date����ת����Calendar����
				Calendar beginTime = Calendar.getInstance();
				beginTime.setTime(beginDate);
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(endDate);
				//��ӡ����
//				System.out.println(CommonUtil.formatDate(beginTime));
//				System.out.println(CommonUtil.formatDate(endTime));
				//�����������ʼ�ͽ���ʱ����в�ѯ
				ArrayList<Car> list = carDao.findCarsByTime(beginTime, endTime);
				int i = 0;
				//��������
				for(Car car : list){
					//��ӡ������Ϣ
					printCarInfo(car, i, true);
					i++;
				}
				System.out.println("��ѡ������");
				int index = sc.nextInt();
				//����ѡ���ȡ��������
				Car car = list.get(index-1);
				//��ӡ��ϸ��Ϣ
				printCarInfo(car, 0, true);
				//��ʾ���������˵�
				carMenu(car);	
			}
			else{
				System.out.println("������������Ƿ���");
			}
		}
		else{
			System.out.println("��ʼ��������Ƿ���");
			searchByTime();
		}
		
	}
	/**
	 * ���ݼ۸���������
	 */
	private void searchByPrice() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * ����Ʒ����������
	 */
	private void searchByBrand() {
		//��ѯ����Ʒ��
		ArrayList<Brand> list = brandDao.findAll();
		int i = 0;
		//������ӡƷ��
		for(Brand brand : list){
			System.out.println(i+1+".\t"+brand.getBrandName());
			i++;
		}
		System.out.println("��ѡ��Ʒ�ƣ�");
		int index = sc.nextInt();
		//����ѡ���ȡƷ��
		Brand brand = list.get(index-1);
		//����Ʒ�Ʊ�Ų�ѯ����
		ArrayList<CarType> typeList = carTypeDao.findListByBrandId(brand.getBrandId());
		//�������ϴ洢���ݳ��Ͳ鵽�����г���
		ArrayList<Car> carList = new ArrayList<Car>();
		//��ӡ������
		i = 0;
		//�������ͼ���
		for(CarType type : typeList){
			//���ݳ��ͱ�Ų��ҳ�������
			ArrayList<Car> searchList = carDao.findCarsByTypeId(type.getTypeId());
			//�����ҵ��ĳ�����������������еĳ���������carList��
			for(Car car : searchList){
				carList.add(car);
				//��ӡ��������Ϣ
				printCarInfo(car, i, false);
				i++;
			}
		}
		System.out.println("��ѡ������");
		index = sc.nextInt();
		//��ȡѡ�еĳ���
		Car car = carList.get(index-1);
		//��ӡ��������ϸ��Ϣ
		printCarInfo(car, 0, true);
		//��ʾ���������˵�
		carMenu(car);
		
	}
	/**
	 * ��ӡ������Ϣ�ķ���
	 * @param car 
	 * @param i ��ӡ������
	 * @param flag true��ʾ��Ҫ��ӡ��ϸ��Ϣ  false��ӡ���Ե���Ϣ
	 */
	private void printCarInfo(Car car, int i, boolean flag){
		//���������ַ���
		StringBuffer str = new StringBuffer();
		//���ݳ����ĳ��ͱ�Ż�ȡ���Ͷ���
		CarType carType = carTypeDao.findCarTypeById(car.getTypeId());
		//���ݳ��Ͷ����е�Ʒ�Ʊ�Ż�ȡƷ�ƶ���
		Brand brand = brandDao.findBrandById(carType.getBrandId());
		if(flag){
			str.append(i+1+"\t");
			str.append(brand.getBrandName()+"\t");
			str.append(carType.getTypeName()+"\t");
			str.append(car.getPrice()+"\t");
			str.append(car.getDistance()+"\t");
			str.append(car.getDisplacement()+"\t");
			str.append(car.getCluthType()+"\t");
			str.append(CommonUtil.formatDate(car.getPublishTime())+"\t");
			str.append(CommonUtil.formatDate(car.getBoardTime()));
			
			System.out.println(str);
		}
		else{
			str.append(i+1+"\t");
			str.append(brand.getBrandName()+"\t");
			str.append(carType.getTypeName()+"\t");
			str.append(car.getPrice()+"\t");
			str.append(car.getDistance()+"\t");
			str.append(CommonUtil.formatDate(car.getPublishTime()));
			System.out.println(str);
		}
	}
}
