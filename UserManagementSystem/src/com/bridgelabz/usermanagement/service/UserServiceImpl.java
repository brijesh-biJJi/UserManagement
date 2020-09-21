package com.bridgelabz.usermanagement.service;

import com.bridgelabz.usermanagement.dao.UserDao;
import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.model.UserPermissions;

public class UserServiceImpl implements IUserService {

	UserDao userDao=new UserDao();

	@Override
	public int register(UserModel userModel) {
		return userDao.registerUser(userModel);
	}


	@Override
	public int setPermission(UserPermissions permissions, String email) {
		int userId = userDao.getUserIdByEmail(email);
		System.out.println("userId "+userId);
		System.out.println("permdash add"+permissions.isDashAdd());
		userDao.setPermission(userId,permissions.isDashAdd(),permissions.isDashDelete(),permissions.isDashModify(),permissions.isDashRead(),1);
		userDao.setPermission(userId, permissions.isSettingsAdd(), permissions.isSettingsDelete(), permissions.isSettingsModify(), permissions.isSettingsRead(), 2);
		userDao.setPermission(userId, permissions.isUsersInfoAdd(), permissions.isUsersInfoDelete(), permissions.isUsersInfoModify(), permissions.isUsersInfoRead(), 3);
		userDao.setPermission(userId, permissions.isWebPage1Add(), permissions.isWebPage1Delete(), permissions.isWebPage1Modify(), permissions.isWebPage1Read(), 4);
		userDao.setPermission(userId, permissions.isWebPage2Add(), permissions.isWebPage2Delete(), permissions.isWebPage2Modify(), permissions.isWebPage2Read(), 5);
		return userDao.setPermission(userId, permissions.isWebPage3Add(), permissions.isWebPage3Delete(), permissions.isWebPage3Modify(), permissions.isWebPage3Read(), 6);
	}


	@Override
	public int deleteUser(int userid) {
		return userDao.deleteUser(userid);
	}
	
	
}
