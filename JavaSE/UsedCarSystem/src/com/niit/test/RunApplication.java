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
		//实例化数据类
		Data data = new Data();
		data.init();
		//实例化系统类
		UsedCarSystem sys = new UsedCarSystem();
		sys.init(data);
		//sys.start(data);
		
//		System.out.println("编号\t\t品牌\t\t车型\t\t价格\t\t\t发布时间");
//		for(int i = 0; i < data.carData.length; i++){
//			if(data.carData[i] != null){
//				System.out.println(data.carData[i].carId+"\t\t"+sys.getBrandName(data.carData[i].brandId)+"\t\t"+sys.getCarTypeName(data.carData[i].typeId)+"\t\t"+data.carData[i].price+"\t\t"+CommonUtil.formatDate(data.carData[i].publishTime));
//			}
//		}
		
		//最新发布的10辆车辆信息
//		Car[] publishCar = sys.getNewPublishCar();
//		System.out.println("编号\t\t品牌\t\t车型\t\t价格\t\t\t发布时间");
//		for(int i = 0; i < publishCar.length; i++){
//			if(publishCar[i] != null){
//				System.out.println(publishCar[i].carId+"\t\t"+publishCar[i].brandId+"\t\t"+publishCar[i].typeId+"\t\t"+publishCar[i].price+"\t\t"+CommonUtil.formatDate(publishCar[i].publishTime));
//			}
//		}
		
//		for(int i = 0; i < data.brandData.length; i++){
//			//第一次元素为null时的位置即要新增品牌的位置
//			if(data.brandData[i] == null){
//				//构建新的品牌对象
//				Brand brand = new Brand();
//				brand.brandId = 4;
//				brand.brandName = "福特";
//				//将新的品牌写入数组
//				data.brandData[i] = brand;
//			}
//		}
		
		/*************显示所有品牌信息，并根据品牌查询对应的车型**************/
		//显示所有品牌可以直接循环品牌数组
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				System.out.println(i+1+". "+data.brandData[i].brandName);
			}
		}
		System.out.println("请选择要搜索的品牌：");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		//根据选择获取选择的品牌编号
		int brandId = data.brandData[choice-1].brandId;
		//存储对应品牌的车型数组
		CarType[] searchTypeArray = new CarType[data.carTypeData.length];
		//根据编号查询该品牌对应的车型
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null){
				//判断车型数组中每个元素的品牌和要搜索的编号是否相同
				if(data.carTypeData[i].brandId == brandId){
					//如果相同就将对应的车型对象存入新数组
					for(int j = 0; j < searchTypeArray.length; j++){
						//查找数组中第一次为默认值的位置，即存储新元素的位置
						if(searchTypeArray[j] == null){
							searchTypeArray[j] = data.carTypeData[i];
							break;
						}
					}
				}
			}
		}
		//打印搜索到的车型
		for(int i = 0; i < searchTypeArray.length; i++){
			if(searchTypeArray[i] != null){
				System.out.println(i+1+". "+searchTypeArray[i].typeName);
			}
		}
		System.out.println("请输入要搜索的车型：");
		choice = sc.nextInt();
		//根据选择获取选择的车型编号
		int typeId = searchTypeArray[choice-1].typeId;
		//根据车型编号和品牌编号查询对应的车辆信息
		//存储满足查询条件的车辆的数组
		Car[] searchCar = new Car[data.carData.length];
		for(int i = 0; i < data.carData.length; i++){
			if(data.carData[i] != null){
				//判断品牌编号和车型编号是否吻合
				if(data.carData[i].brandId == brandId && data.carData[i].typeId == typeId){
					for(int j = 0; j < searchCar.length; j++){
						//找到第一个为默认值的元素位置
						if(searchCar[j] == null){
							searchCar[j] = data.carData[i];
							break;
						}
					}
				}
			}
		}
		//打印查询到的信息
		for(int i = 0; i < searchCar.length; i++){
			if(searchCar[i] != null){
				System.out.println(i+1+". "+sys.getBrandName(searchCar[i].brandId)+"\t"+sys.getCarTypeName(searchCar[i].typeId)+"\t"+searchCar[i].price);
			}
		}
		
	}
}
