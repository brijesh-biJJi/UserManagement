package com.bridgelabz.usermanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.usermanagement.dao.UserDao;
import com.bridgelabz.usermanagement.model.UserModel;

/**
 * Servlet implementation class UsersList
 */
@WebServlet("/UsersList")
public class UsersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersList() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		
		 String action = request.getParameter("action");
	     HttpSession session = request.getSession(true);

	     if(action.equals("displayUsers")){
	            ArrayList<UserModel> usersList = (ArrayList<UserModel>) userDao.getAllUser();
	           System.out.println("user list in controller "+usersList);
	            session.setAttribute("usersList", usersList);
	            RequestDispatcher rd =null;
	            rd=request.getRequestDispatcher("/userdetails");
	            rd.forward(request, response);
	     }
	}



}
