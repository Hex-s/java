package com.niit;

public class Exam2 {
	
	/**
	 * ȥ����߿ո�ķ���
	 * @param str
	 * @return
	 */
	public String trimLeft(String str){
		int index = 0;
		//�����ַ���
		for(int i = 0; i < str.length(); i++){
			//��ȡ��һ�β�Ϊ�ո���ַ�����
			if(str.charAt(i) != ' '){
				index = i;
				break;
			}
		}
		return str.substring(index);
	}
	/**
	 * ȥ���ұ߿ո�ķ���
	 * @param str  niit   
	 * @return
	 */
	public String trimRight(String str){
		int index = 0;
		//���ַ�����β�˽��б���
		for(int i = str.length()-1; i >= 0; i--){
			//��ȡ��һ�β�Ϊ�ո���ַ�����
			if(str.charAt(i) != ' '){
				index = i;
				break;
			}
		}
		return str.substring(0,index+1);
	}
	/**
	 * ȥ�����ҿո�ķ���
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
//				System.out.println("�������һ�����ϵ������û���");
//				break;
//			}
			
			//if((ch < '0' || ch > '9') && (ch < 'a' || ch > 'z') && ch != '_')
		}
	}
}
