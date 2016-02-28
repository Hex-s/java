package com.niit;

public class Exam1 {

	public int search(String sourceStr, String searchStr){
		//起始的搜索索引位置
		int index = 0;
		//搜索字符串出现的次数
		int count = 0;
		//搜索字符串的长度
		int length = searchStr.length();
		//通过循环反复搜索
		//如果还能搜索到字符串，则继续搜索
		while(sourceStr.indexOf(searchStr,index) != -1){
			//累加搜索到次数
			count++;
			//记录每一次搜索字符串的索引
			index = sourceStr.indexOf(searchStr,index);
			System.out.println("第"+count+"次搜索到的位置是："+index);
			//变更索引，表示下一次查找从搜索到字符串的后一位开始搜索
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
