package com.niit;

public class Exam1 {

	public int search(String sourceStr, String searchStr){
		//��ʼ����������λ��
		int index = 0;
		//�����ַ������ֵĴ���
		int count = 0;
		//�����ַ����ĳ���
		int length = searchStr.length();
		//ͨ��ѭ����������
		//��������������ַ��������������
		while(sourceStr.indexOf(searchStr,index) != -1){
			//�ۼ�����������
			count++;
			//��¼ÿһ�������ַ���������
			index = sourceStr.indexOf(searchStr,index);
			System.out.println("��"+count+"����������λ���ǣ�"+index);
			//�����������ʾ��һ�β��Ҵ��������ַ����ĺ�һλ��ʼ����
			index+=length;
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex = new Exam1();
		ex.search("abaasdfbavasecbvabcbab", "ab");

	}

}
