package com.bridgelabz.usermanagement.service;

import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.model.UserPermissions;

public interface IUserService {
	public UserModel resgister(UserModel userModel);

	void addPermission(UserPermissions permissions);
	
	
}
