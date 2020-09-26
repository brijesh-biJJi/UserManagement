package com.bridgelabz.usermanagement.service;

import com.bridgelabz.usermanagement.dao.DashboardDao;
import com.bridgelabz.usermanagement.dao.UserDao;

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
	
}
