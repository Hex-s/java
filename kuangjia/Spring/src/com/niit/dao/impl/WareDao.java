package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.bean.Ware;
import com.niit.dao.iface.IWareDao;
import com.niit.dao.util.CommonDao;

/**
 * 商品数据操作类
 * @author Administrator
 *
 */
public class WareDao extends CommonDao implements IWareDao {

	public ArrayList<Ware> findAll() {
		ArrayList<Ware> list = new ArrayList<Ware>();
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from ware");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Ware ware = new Ware(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
				list.add(ware);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Ware findWareById(int wareId) {
		return null;
	}

	public void modifyWare(Ware ware) {
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("update ware set price=? where wareId=?");
			pstmt.setDouble(1, ware.getPrice());
			pstmt.setInt(2, ware.getWareId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
