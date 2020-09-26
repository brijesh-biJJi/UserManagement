package com.bridgelabz.usermanagement.service;

import java.util.List;

import com.bridgelabz.usermanagement.model.UserModel;

public interface IDashboard {

	Long getTotalUsers();

	String getUserLastLogin(int userId);

	Long getTotalUsersByStatus(String status);

	List<UserModel> getLatestRegistrations(int i);

}
