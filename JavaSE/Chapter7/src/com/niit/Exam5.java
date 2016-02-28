package com.niit;

public class Exam5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[]{87,67,34,20,98,73,59};
		//冒泡排序
		//desc降序排列
		//外层循环控制比较的轮数
//		for(int i = 1; i < array.length; i++){
//			//里层循环控制每一轮比较的次数,-i表示每一轮不需要比较的次数
//			for(int j = 0; j < array.length-i; j++ ){
//				//每次依次将当前元素和下一个元素进行比较
//				if(array[j] < array[j+1]){
//					//交换两数
//					int temp = array[j];
//					array[j] = array[j+1];
//					array[j+1] = temp;
//				}
//			}
//		}
		
		//控制的比较的轮数
		//i表示每一轮比较的第一个数，该数在每一轮的比较都是同一个元素
//		for(int i = 0; i < array.length-1; i++){
//			//控制比较的次数
//			//j表示要比较的第二个数，在每一轮的比较中，第二个数是不断变化的
//			for(int j = i+1; j < array.length; j++){
//				if(array[i] < array[j]){
//					int temp = array[i];
//					array[i] = array[j];
//					array[j] = temp;
//				}
//			}
//		}
		
		//外层循环控制比较的第二个数
		for(int i = 1; i < array.length; i++){
			//里层循环控制要比较的第一个数，每一轮比较时，第一个数都从数组的第一个元素开始，每次比较都递增，直至第二个数的索引位置
			for(int j = 0; j < i; j++){
				if(array[j] < array[i]){
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		
		Exam3 ex = new Exam3();
		//打印显示数组
		ex.showArray(array, array.length);
		
	}

}
