package com.bridgelabz.usermanagement.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.usermanagement.dao.UserDao;
import com.bridgelabz.usermanagement.model.UserModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    }

   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao=new UserDao();
		UserModel user=new UserModel();
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		ResultSet rs=userDao.checkLogin(email, pass);
		try {
			if(rs.next()) {
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
				user.setFirst_name(fname);
				user.setLast_name(lname);
				
				HttpSession session=request.getSession();
				session.setAttribute("username", user);
				response.sendRedirect("dashboard");
			}
			else
				response.sendRedirect("login");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

}
