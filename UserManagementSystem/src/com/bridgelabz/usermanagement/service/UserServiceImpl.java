package com.bridgelabz.usermanagement.service;

import java.util.List;

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


	@Override
	public Long getTotalUsers() {
		return userDao.getTotalUsers();
	}


	@Override
	public List<UserModel> getUsersByPageSize(int pageId, int totalUserByPage) {
		int start = (pageId-1)*totalUserByPage;
        return userDao.getUsersByPageSize(start,totalUserByPage);
	}


	@Override
	public UserModel getUserDetails(int userId) {
		return  userDao.getUserDetails(userId);
	}


	@Override
	public UserPermissions getUserPermissions(int userId) {
		UserPermissions permissions = new UserPermissions();

		List<Boolean> dashPermissions = userDao.getUserPermissions(userId, 1);
		permissions.setDashAdd(dashPermissions.get(0));
		permissions.setDashDelete(dashPermissions.get(1));
		permissions.setDashModify(dashPermissions.get(2));
		permissions.setDashRead(dashPermissions.get(3));

		List<Boolean> settingsPermissions = userDao.getUserPermissions(userId, 2);
		permissions.setSettingsAdd(settingsPermissions.get(0));
		permissions.setSettingsDelete(settingsPermissions.get(1));
		permissions.setSettingsModify(settingsPermissions.get(2));
		permissions.setSettingsRead(settingsPermissions.get(3));

		List<Boolean> userInformationPermissions = userDao.getUserPermissions(userId, 3);
		permissions.setUsersInfoAdd(userInformationPermissions.get(0));
		permissions.setUsersInfoDelete(userInformationPermissions.get(1));
		permissions.setUsersInfoModify(userInformationPermissions.get(2));
		permissions.setUsersInfoRead(userInformationPermissions.get(3));

		List<Boolean> webPage1Permissions = userDao.getUserPermissions(userId, 4);
		permissions.setWebPage1Add(webPage1Permissions.get(0));
		permissions.setWebPage1Delete(webPage1Permissions.get(1));
		permissions.setWebPage1Modify(webPage1Permissions.get(2));
		permissions.setWebPage1Read(webPage1Permissions.get(3));

		List<Boolean> webPage2Permissions = userDao.getUserPermissions(userId, 5);
		permissions.setWebPage2Add(webPage2Permissions.get(0));
		permissions.setWebPage2Delete(webPage2Permissions.get(1));
		permissions.setWebPage2Modify(webPage2Permissions.get(2));
		permissions.setWebPage2Read(webPage2Permissions.get(3));

		List<Boolean> webPage3Permissions = userDao.getUserPermissions(userId, 6);
		permissions.setWebPage3Add(webPage3Permissions.get(0));
		permissions.setWebPage3Delete(webPage3Permissions.get(1));
		permissions.setWebPage3Modify(webPage3Permissions.get(2));
		permissions.setWebPage3Read(webPage3Permissions.get(3));
		return permissions;
	}


	@Override
	public int updateUser(int userId, UserModel user) {
		return userDao.updateUser(userId, user);
	}


	@Override
	public int updatePermission(int userId, UserPermissions permissions) {
		System.out.println("userId "+userId);
		System.out.println("permdash add"+permissions.isDashAdd());
		userDao.updatePermission(userId,permissions.isDashAdd(),permissions.isDashDelete(),permissions.isDashModify(),permissions.isDashRead(),1);
		userDao.updatePermission(userId, permissions.isSettingsAdd(), permissions.isSettingsDelete(), permissions.isSettingsModify(), permissions.isSettingsRead(), 2);
		userDao.updatePermission(userId, permissions.isUsersInfoAdd(), permissions.isUsersInfoDelete(), permissions.isUsersInfoModify(), permissions.isUsersInfoRead(), 3);
		userDao.updatePermission(userId, permissions.isWebPage1Add(), permissions.isWebPage1Delete(), permissions.isWebPage1Modify(), permissions.isWebPage1Read(), 4);
		userDao.updatePermission(userId, permissions.isWebPage2Add(), permissions.isWebPage2Delete(), permissions.isWebPage2Modify(), permissions.isWebPage2Read(), 5);
		return userDao.updatePermission(userId, permissions.isWebPage3Add(), permissions.isWebPage3Delete(), permissions.isWebPage3Modify(), permissions.isWebPage3Read(), 6);
	
	}
	
	
}
