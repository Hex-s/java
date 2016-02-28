package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.Brand;

/**
 * 品牌对象数据操作接口
 * @author Administrator
 *
 */
public interface IBrandDao {
	
	/**
	 * 根据品牌编号查找
	 * @param brandId
	 * @return
	 */
	public Brand findBrandById(int brandId);
	
	/**
	 * 查找所有品牌
	 * @return
	 */
	public ArrayList<Brand> findAll();
	
	/**
	 * 添加品牌
	 */
	public void add(Brand brand);
}
