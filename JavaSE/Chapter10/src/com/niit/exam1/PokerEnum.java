package com.niit.exam1;
/**
 * �˿��ƻ�ɫö������
 * ö�ٵ�ֵд��ö�������У����ֵʹ�ö��ż��
 * ö�������һ����������
 * @author Administrator
 *
 */
public enum PokerEnum {
	//ö�ٵ�ֵ�Ǹ����ʵ������
	spade("����"),
	heart("����"),
	club("÷��"),
	diamond("����");
	
	private String name;
	
	private PokerEnum(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
