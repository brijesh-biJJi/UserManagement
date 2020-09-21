package com.bridgelabz.usermanagement.service;

import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.model.UserPermissions;

public interface IUserService {
	public int register(UserModel userModel);

	int setPermission(UserPermissions permissions, String username);

	public int deleteUser(int userid);

}
