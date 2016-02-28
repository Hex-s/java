package com.niit.bean;

import com.niit.util.CommonUtil;

/**
 * ������
 * @author Administrator
 *
 */
public class CarType {
	//���ͱ��
	private int typeId;
	//��������
	private String typeName;
	//Ʒ�Ʊ��
	private int brandId;
	
	public CarType(String typeName, int brandId){
		this.typeId = CommonUtil.getTypeId();
		this.typeName = typeName;
		this.brandId = brandId;
	}
	public CarType(){
		
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
}
