package com.niit.bean;

import com.niit.util.CommonUtil;

/**
 * Ʒ����
 * @author Administrator
 *
 */
public class Brand {
	//Ʒ�Ʊ��
	private int brandId;
	//Ʒ������
	private String brandName;
	
	public Brand(String brandName){
		this.brandId = CommonUtil.getBrandId();
		this.brandName = brandName;
	}
	
	public Brand(){
		
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
