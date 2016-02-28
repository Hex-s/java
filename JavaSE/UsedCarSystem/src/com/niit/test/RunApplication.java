package com.niit.test;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.data.Data;
import com.niit.sys.UsedCarSystem;
import com.niit.util.CommonUtil;

public class RunApplication {

	public static void main(String[] args) {
		//ʵ����������
		Data data = new Data();
		data.init();
		//ʵ����ϵͳ��
		UsedCarSystem sys = new UsedCarSystem();
		sys.init(data);
		//sys.start(data);
		
//		System.out.println("���\t\tƷ��\t\t����\t\t�۸�\t\t\t����ʱ��");
//		for(int i = 0; i < data.carData.length; i++){
//			if(data.carData[i] != null){
//				System.out.println(data.carData[i].carId+"\t\t"+sys.getBrandName(data.carData[i].brandId)+"\t\t"+sys.getCarTypeName(data.carData[i].typeId)+"\t\t"+data.carData[i].price+"\t\t"+CommonUtil.formatDate(data.carData[i].publishTime));
//			}
//		}
		
		//���·�����10��������Ϣ
//		Car[] publishCar = sys.getNewPublishCar();
//		System.out.println("���\t\tƷ��\t\t����\t\t�۸�\t\t\t����ʱ��");
//		for(int i = 0; i < publishCar.length; i++){
//			if(publishCar[i] != null){
//				System.out.println(publishCar[i].carId+"\t\t"+publishCar[i].brandId+"\t\t"+publishCar[i].typeId+"\t\t"+publishCar[i].price+"\t\t"+CommonUtil.formatDate(publishCar[i].publishTime));
//			}
//		}
		
//		for(int i = 0; i < data.brandData.length; i++){
//			//��һ��Ԫ��Ϊnullʱ��λ�ü�Ҫ����Ʒ�Ƶ�λ��
//			if(data.brandData[i] == null){
//				//�����µ�Ʒ�ƶ���
//				Brand brand = new Brand();
//				brand.brandId = 4;
//				brand.brandName = "����";
//				//���µ�Ʒ��д������
//				data.brandData[i] = brand;
//			}
//		}
		
		/*************��ʾ����Ʒ����Ϣ��������Ʒ�Ʋ�ѯ��Ӧ�ĳ���**************/
		//��ʾ����Ʒ�ƿ���ֱ��ѭ��Ʒ������
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				System.out.println(i+1+". "+data.brandData[i].brandName);
			}
		}
		System.out.println("��ѡ��Ҫ������Ʒ�ƣ�");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		//����ѡ���ȡѡ���Ʒ�Ʊ��
		int brandId = data.brandData[choice-1].brandId;
		//�洢��ӦƷ�Ƶĳ�������
		CarType[] searchTypeArray = new CarType[data.carTypeData.length];
		//���ݱ�Ų�ѯ��Ʒ�ƶ�Ӧ�ĳ���
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null){
				//�жϳ���������ÿ��Ԫ�ص�Ʒ�ƺ�Ҫ�����ı���Ƿ���ͬ
				if(data.carTypeData[i].brandId == brandId){
					//�����ͬ�ͽ���Ӧ�ĳ��Ͷ������������
					for(int j = 0; j < searchTypeArray.length; j++){
						//���������е�һ��ΪĬ��ֵ��λ�ã����洢��Ԫ�ص�λ��
						if(searchTypeArray[j] == null){
							searchTypeArray[j] = data.carTypeData[i];
							break;
						}
					}
				}
			}
		}
		//��ӡ�������ĳ���
		for(int i = 0; i < searchTypeArray.length; i++){
			if(searchTypeArray[i] != null){
				System.out.println(i+1+". "+searchTypeArray[i].typeName);
			}
		}
		System.out.println("������Ҫ�����ĳ��ͣ�");
		choice = sc.nextInt();
		//����ѡ���ȡѡ��ĳ��ͱ��
		int typeId = searchTypeArray[choice-1].typeId;
		//���ݳ��ͱ�ź�Ʒ�Ʊ�Ų�ѯ��Ӧ�ĳ�����Ϣ
		//�洢�����ѯ�����ĳ���������
		Car[] searchCar = new Car[data.carData.length];
		for(int i = 0; i < data.carData.length; i++){
			if(data.carData[i] != null){
				//�ж�Ʒ�Ʊ�źͳ��ͱ���Ƿ��Ǻ�
				if(data.carData[i].brandId == brandId && data.carData[i].typeId == typeId){
					for(int j = 0; j < searchCar.length; j++){
						//�ҵ���һ��ΪĬ��ֵ��Ԫ��λ��
						if(searchCar[j] == null){
							searchCar[j] = data.carData[i];
							break;
						}
					}
				}
			}
		}
		//��ӡ��ѯ������Ϣ
		for(int i = 0; i < searchCar.length; i++){
			if(searchCar[i] != null){
				System.out.println(i+1+". "+sys.getBrandName(searchCar[i].brandId)+"\t"+sys.getCarTypeName(searchCar[i].typeId)+"\t"+searchCar[i].price);
			}
		}
		
	}
}
