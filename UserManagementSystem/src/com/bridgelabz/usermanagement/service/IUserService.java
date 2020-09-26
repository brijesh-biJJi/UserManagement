package com.bridgelabz.usermanagement.service;

import java.util.List;

import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.model.UserPermissions;

public interface IUserService {
	public int register(UserModel userModel);

	int setPermission(UserPermissions permissions, String username);

	public int deleteUser(int userid);

	public Long getTotalUsers();

	public List<UserModel> getUsersByPageSize(int i, int j);

	public UserModel getUserDetails(int userId);

	public UserPermissions getUserPermissions(int userId);

	int updateUser(int userId, UserModel user);

	int updatePermission(int userId, UserPermissions permissions);

	public void updateUserLogin(int user_id);

	public List<Boolean> getPagePermissions(int userId, int i);

	
}
