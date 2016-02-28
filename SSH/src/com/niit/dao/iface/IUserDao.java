package com.niit.dao.iface;

import com.niit.pojo.User;

public interface IUserDao {
	public User findUserByName(String userName);
}
