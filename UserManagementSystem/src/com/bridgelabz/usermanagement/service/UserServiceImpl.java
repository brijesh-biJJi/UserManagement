package com.bridgelabz.usermanagement.service;

import com.bridgelabz.usermanagement.dao.UserDao;
import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.model.UserPermissions;

public class UserServiceImpl implements IUserService {

	UserDao userDao=new UserDao();
	
	@Override
	public UserModel resgister(UserModel user) {
		userDao.addUser(user);
		return null;
	}

	@Override
	public void addPermission(UserPermissions permissions) {
		
	}
	
}
