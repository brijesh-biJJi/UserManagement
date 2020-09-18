package com.bridgelabz.usermanagement.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.model.UserPermissions;
import com.bridgelabz.usermanagement.service.UserServiceImpl;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/newuser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email       =request.getParameter("email");         
		 String first_name  =request.getParameter("f_name");     
		 String middle_name =request.getParameter("m_name");
		 String last_name   =request.getParameter("l_name");   
//		 Date dob           =request.getParameter("dob");
	     int phone 			=Integer.parseInt(request.getParameter("phone"));
	     String address 	=request.getParameter("address");     
	     String username 	=request.getParameter("username");		
	     String password 	=request.getParameter("pass");   
	     
	     UserModel user=new UserModel();
	     
	     user.setEmail(email);
	     user.setFirst_name(first_name);
	     user.setLast_name(last_name);
	     user.setMiddle_name(middle_name);
	     user.setPhone(phone);
	     user.setAddress(address);
	     user.setUsername(username);
	     user.setPassword(password);
	     user.setCreator_at(LocalDateTime.now());
	     
	     UserPermissions permissions=new UserPermissions();
	     permissions.setDashAdd(Boolean.parseBoolean(request.getParameter("dash-add")));
	     permissions.setDashDelete(Boolean.parseBoolean(request.getParameter("dash-delete")));
	     permissions.setDashModify(Boolean.parseBoolean(request.getParameter("dash-modify")));
	     permissions.setDashRead(Boolean.parseBoolean(request.getParameter("dash-read")));
	     
	     permissions.setSettingsAdd(Boolean.parseBoolean(request.getParameter("settings-add")));
	     permissions.setSettingsDelete(Boolean.parseBoolean(request.getParameter("settings-delete")));
	     permissions.setSettingsModify(Boolean.parseBoolean(request.getParameter("settings-modify")));
	     permissions.setSettingsModify(Boolean.parseBoolean(request.getParameter("settings-read")));

	     permissions.setUsersInfoAdd(Boolean.parseBoolean(request.getParameter("userinfo-add")));
	     permissions.setUsersInfoAdd(Boolean.parseBoolean(request.getParameter("userinfo-delete")));
	     permissions.setUsersInfoAdd(Boolean.parseBoolean(request.getParameter("userinfo-modify")));
	     permissions.setUsersInfoAdd(Boolean.parseBoolean(request.getParameter("userinfo-read")));
	     
	     permissions.setWebPage1Add(Boolean.parseBoolean(request.getParameter("wp1-add")));
	     permissions.setWebPage1Add(Boolean.parseBoolean(request.getParameter("wp1-delete")));
	     permissions.setWebPage1Add(Boolean.parseBoolean(request.getParameter("wp1-modify")));
	     permissions.setWebPage1Add(Boolean.parseBoolean(request.getParameter("wp1-read")));
	     
	     permissions.setWebPage2Add(Boolean.parseBoolean(request.getParameter("wp2-add")));
	     permissions.setWebPage2Add(Boolean.parseBoolean(request.getParameter("wp2-delete")));
	     permissions.setWebPage2Add(Boolean.parseBoolean(request.getParameter("wp2-modify")));
	     permissions.setWebPage2Add(Boolean.parseBoolean(request.getParameter("wp2-read")));
	     
	     permissions.setWebPage2Add(Boolean.parseBoolean(request.getParameter("wp3-add")));
	     permissions.setWebPage2Add(Boolean.parseBoolean(request.getParameter("wp3-delete")));
	     permissions.setWebPage2Add(Boolean.parseBoolean(request.getParameter("wp3-modify")));
	     permissions.setWebPage2Add(Boolean.parseBoolean(request.getParameter("wp3-read")));
	     
	     
	     
	     UserServiceImpl userService=new UserServiceImpl();
	     UserModel userModel=userService.resgister(user);
	     
	     if(userModel != null) {
	    	 userService.addPermission(permissions);
	     }
	}

}
