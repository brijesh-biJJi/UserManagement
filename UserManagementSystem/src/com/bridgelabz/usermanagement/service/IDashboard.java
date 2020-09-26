package com.bridgelabz.usermanagement.service;

public interface IDashboard {

	Long getTotalUsers();

	String getUserLastLogin(int userId);

	Long getTotalUsersByStatus(String status);

}
