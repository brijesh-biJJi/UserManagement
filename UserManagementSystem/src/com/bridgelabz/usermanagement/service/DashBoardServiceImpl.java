package com.bridgelabz.usermanagement.service;

import java.util.List;

import com.bridgelabz.usermanagement.dao.DashboardDao;
import com.bridgelabz.usermanagement.dao.UserDao;
import com.bridgelabz.usermanagement.model.UserModel;

public class DashBoardServiceImpl implements IDashboard{
	
	UserDao userDao=new UserDao();
	DashboardDao dashDao = new DashboardDao();
	
	@Override
	public Long getTotalUsers() {
		return dashDao.getTotalUsers();
	}
	
	@Override
	public String getUserLastLogin(int userId) {
		return dashDao.getUserLastLogin(userId);
	}
	
	@Override
	public Long getTotalUsersByStatus(String status) {
        return dashDao.getTotalUsersByStatus(status);
    }

	@Override
	public List<UserModel> getLatestRegistrations(int totalUser) {
		 return dashDao.getLatestRegistrations(totalUser);
	}
	
}
