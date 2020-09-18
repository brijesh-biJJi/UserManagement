package com.bridgelabz.usermanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.usermanagement.dao.UserDao;

/**
 * Servlet implementation class ForgotServlet
 */
@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd;
			String email = request.getParameter("email");
			UserDao userDao=new UserDao();
			boolean rs=userDao.passwordRecovery(email);	
			String notification;
			if(rs) {
				notification="The Password has been sent to your E-mail Address";

			request.setAttribute("notify", notification);
			response.sendRedirect("jsp/login.jsp");
			}
			else
			{
				notification="Specified email doest not exists in our record";
				request.setAttribute("notify", notification);
				response.sendRedirect("jsp/forgotpassword.jsp");
			}
	}

}
