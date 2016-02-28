package com.niit;

public class Exam2 {
	
	/**
	 * 去除左边空格的方法
	 * @param str
	 * @return
	 */
	public String trimLeft(String str){
		int index = 0;
		//遍历字符串
		for(int i = 0; i < str.length(); i++){
			//获取第一次不为空格的字符索引
			if(str.charAt(i) != ' '){
				index = i;
				break;
			}
		}
		return str.substring(index);
	}
	/**
	 * 去除右边空格的方法
	 * @param str  niit   
	 * @return
	 */
	public String trimRight(String str){
		int index = 0;
		//从字符串的尾端进行遍历
		for(int i = str.length()-1; i >= 0; i--){
			//获取第一次不为空格的字符索引
			if(str.charAt(i) != ' '){
				index = i;
				break;
			}
		}
		return str.substring(0,index+1);
	}
	/**
	 * 去除左右空格的方法
	 * @param str
	 * @return
	 */
	public String trim(String str){
		return trimLeft(trimRight(str));
	}
	
	public static void main(String[] args) {
		String str =  "adsasda";
		for(int i = 0; i< str.length() ; i++){
			char ch = str.charAt(i);
//			if(!(tt == '_' || tt>='0' && tt<='9' || tt>='a' && tt<='z' || tt >='A' && tt <='Z')){
//				System.out.println("这个不是一个符合的邮箱用户名");
//				break;
//			}
			
			//if((ch < '0' || ch > '9') && (ch < 'a' || ch > 'z') && ch != '_')
		}
	}
}
