package com.niit.exam3;

public class FinallyExam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = new int[10];
		try {
			array[10] = 10;
			System.out.println(array[10]);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//finally��ʾ�����쳣�Ƿ�����ʼ�ն���ִ�еĴ����
		finally{
			System.out.println("����ִ�н���");
		}
		
		
	}

}
