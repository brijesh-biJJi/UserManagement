package com.bridgelabz.usermanagement.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.model.UserPermissions;
import com.bridgelabz.usermanagement.service.IUserService;
import com.bridgelabz.usermanagement.service.UserServiceImpl;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		UserModel user = userService.getUserDetails(userId);
		
		UserPermissions permissions=null;
		if(user !=null)
			permissions = userService.getUserPermissions(userId);
		
		request.setAttribute("user", user);
		request.setAttribute("permissions", permissions);
		request.getRequestDispatcher("edituser").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		 String email       =request.getParameter("email"); 
		 String first_name  =request.getParameter("f_name"); 
		 String middle_name =request.getParameter("m_name");
		 String last_name   =request.getParameter("l_name");   
		 String dob         =request.getParameter("dob");
		 String gender      =request.getParameter("gender");
	     long phone 			=Long.parseLong(request.getParameter("phon"));
	     String address 	=request.getParameter("address");     
	     String username 	=request.getParameter("username");		
	     String password 	=request.getParameter("password");   
	     String country 	=request.getParameter("country");
	     String user_role 	=request.getParameter("role"); 
	     
	     System.out.println("email "+email+"\nfname "+first_name+"\nlname "+last_name+"\ndob "+dob+"\ngen "+gender+"\nphone "+phone+"\nadd "+address+"\nuser "+username+"\npas "+password+"\ncun "+country+"\nrole "+user_role);
	     
	     UserModel user=new UserModel();
	     
	     user.setEmail(email);
	     user.setFirst_name(first_name);
	     user.setLast_name(last_name);
	     user.setMiddle_name(middle_name);
	     user.setDob(dob);
	     user.setGender(gender);
	     user.setPhone(phone);
	     user.setAddress(address);
	     user.setUsername(username);
	     user.setPassword(password);
	     user.setCountry(country);
	     user.setUser_role(user_role);
	     user.setStatus("active");
	     
	     UserServiceImpl userService=new UserServiceImpl();
	     int userResult=userService.updateUser(userId, user);
	     
	     if(userResult > 0) {
	    	 UserPermissions permissions=new UserPermissions();
		     permissions.setDashAdd((null != request.getParameter("dash-add")));
		     permissions.setDashDelete((null != request.getParameter("dash-delete")));
		     permissions.setDashModify((null !=request.getParameter("dash-modify")));
		     permissions.setDashRead((null !=request.getParameter("dash-read")));
		     
		     permissions.setSettingsAdd((null !=request.getParameter("settings-add")));
		     permissions.setSettingsDelete((null !=request.getParameter("settings-delete")));
		     permissions.setSettingsModify((null !=request.getParameter("settings-modify")));
		     permissions.setSettingsModify(Boolean.parseBoolean(request.getParameter("settings-read")));

		     permissions.setUsersInfoAdd((null !=request.getParameter("userinfo-add")));
		     permissions.setUsersInfoAdd((null !=request.getParameter("userinfo-delete")));
		     permissions.setUsersInfoAdd((null !=request.getParameter("userinfo-modify")));
		     permissions.setUsersInfoAdd((null !=request.getParameter("userinfo-read")));
		     
		     permissions.setWebPage1Add((null !=request.getParameter("wp1-add")));
		     permissions.setWebPage1Add((null !=request.getParameter("wp1-delete")));
		     permissions.setWebPage1Add((null !=request.getParameter("wp1-modify")));
		     permissions.setWebPage1Add((null !=request.getParameter("wp1-read")));
		     
		     permissions.setWebPage2Add((null !=request.getParameter("wp2-add")));
		     permissions.setWebPage2Add((null !=request.getParameter("wp2-delete")));
		     permissions.setWebPage2Add((null !=request.getParameter("wp2-modify")));
		     permissions.setWebPage2Add((null !=request.getParameter("wp2-read")));
		     
		     permissions.setWebPage2Add((null !=request.getParameter("wp3-add")));
		     permissions.setWebPage2Add((null !=request.getParameter("wp3-delete")));
		     permissions.setWebPage2Add((null !=request.getParameter("wp3-modify")));
		     permissions.setWebPage2Add((null !=request.getParameter("wp3-read")));
		     
	    	 int permissionResult=userService.updatePermission(userId,permissions);
	    	 if (permissionResult >0 ) {
	    		 System.out.println("Permission is Updated "+permissionResult);
					request.setAttribute("updateduser", "User Updated Successfully.....");
				}
	     }
//	     request.getRequestDispatcher("edituser").forward(request, response);
	     response.sendRedirect("EditUser?userId="+userId);
	}

}
