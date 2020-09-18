package com.bridgelabz.usermanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("webpage1 add --------"+Boolean.parseBoolean(request.getParameter("wp1-add")));
		 System.out.println("webpage1 null check --------"+request.getParameter("wp1-add"));
		 System.out.println("fname --------"+request.getParameter("f_name"));
		 System.out.println("fname --------"+request.getParameter("mail"));
	}

}
