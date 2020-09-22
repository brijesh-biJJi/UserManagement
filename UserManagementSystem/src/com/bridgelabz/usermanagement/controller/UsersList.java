package com.bridgelabz.usermanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.usermanagement.dao.UserDao;
import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.service.IUserService;
import com.bridgelabz.usermanagement.service.UserServiceImpl;

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
		
		
		 String action = request.getParameter("action");

	     if(action.equals("displayUsers")){
	    	 
	    	 IUserService service = new UserServiceImpl();
	         Long totalUsersCount = service.getTotalUsers();
	         request.setAttribute("totalUsersCount",totalUsersCount);
	         
	         int totalUserByPage=10;
	         request.setAttribute("totalUserByPage",totalUserByPage);
	         
	         int pageId=1;
	         request.getSession().setAttribute("active-page",pageId);
	         
	         List<UserModel> usersList = service.getUsersByPageSize(pageId,totalUserByPage);
	         request.setAttribute("usersList", usersList);
	         
	         int noOfPages = (int) Math.floor(totalUsersCount * 1.0 / totalUserByPage);
	         System.out.println("pgess per "+noOfPages);
	         request.setAttribute("noOfPages",noOfPages);
	         
	         request.setAttribute("start",pageId);
	         request.setAttribute("end",usersList.size());
	         
	         RequestDispatcher rd = request.getRequestDispatcher("userdetails");
	         rd.forward(request, response);   
	     }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 Integer pageId;
		
		IUserService service = new UserServiceImpl();
        Long totalUsersCount = service.getTotalUsers();
        request.setAttribute("totalUsersCount",totalUsersCount);
        
        
        int totalUserByPage=Integer.parseInt(request.getParameter("pageSize"));
        request.setAttribute("totalUserByPage",totalUserByPage);
        
        String page = request.getParameter("active-page-id");
        
        if (page == null)
            pageId = (Integer) session.getAttribute("active-page");
        else {
            pageId = Integer.parseInt(page);
            request.getSession().setAttribute("active-page",pageId);
            request.setAttribute("active",pageId);
        }
        
        List<UserModel> usersList = service.getUsersByPageSize(pageId,totalUserByPage);
        request.setAttribute("usersList", usersList);
        
        request.setAttribute("active",pageId);
        
        int noOfPages = (int) Math.floor(totalUsersCount * 1.0 / totalUserByPage);
        System.out.println("pgess per "+noOfPages);
        request.setAttribute("noOfPages",noOfPages);
       
        int start = (pageId-1)*totalUserByPage;
        request.setAttribute("start",start+1);
        request.setAttribute("end",start + usersList.size());
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("userdetails");
        rd.forward(request, response);
	}



}
