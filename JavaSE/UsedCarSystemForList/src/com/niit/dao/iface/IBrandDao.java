package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.Brand;

/**
 * Ʒ�ƶ������ݲ����ӿ�
 * @author Administrator
 *
 */
public interface IBrandDao {
	
	/**
	 * ����Ʒ�Ʊ�Ų���
	 * @param brandId
	 * @return
	 */
	public Brand findBrandById(int brandId);
	
	/**
	 * ��������Ʒ��
	 * @return
	 */
	public ArrayList<Brand> findAll();
	
	/**
	 * ���Ʒ��
	 */
	public void add(Brand brand);
}
