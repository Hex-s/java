package com.niit.dao.impl;

import java.util.List;

import com.niit.dao.iface.IUserDao;
import com.niit.pojo.User;

public class UserDao extends CommonDao<User> implements IUserDao {
	
	public void modifyUser(User user){
		updae(user);
	}
	public User findUserByName(String userName) {
		User user = null;
		List<User> list = findByHql("from User where userName=?", new Object[]{userName});
		if(!list.isEmpty()){
			user = list.get(0);
		}
		return user;
	}

}
