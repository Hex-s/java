package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.bean.Brand;
import com.niit.dao.iface.IBrandDao;
import com.niit.data.Data;

public class BrandDao implements IBrandDao {

	private ArrayList<Brand> brandData;
	
	public BrandDao(Data data){
		this.brandData = data.getBrandData();
	}
	
	public ArrayList<Brand> findAll(){
		return this.brandData;
	}

	@Override
	public void add(Brand brand) {
		// TODO Auto-generated method stub
		brandData.add(brand);
	}

	@Override
	public Brand findBrandById(int brandId) {
		for(Brand brand : brandData){
			if(brand.getBrandId() == brandId){
				return brand;
			}
		}
		return null;
	}
	
	
}
