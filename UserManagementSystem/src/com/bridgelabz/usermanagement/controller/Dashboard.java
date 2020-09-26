package com.bridgelabz.usermanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.service.DashBoardServiceImpl;
import com.bridgelabz.usermanagement.service.IDashboard;
import com.bridgelabz.usermanagement.service.IUserService;
import com.bridgelabz.usermanagement.service.UserServiceImpl;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		IUserService service = new UserServiceImpl();
        IDashboard dashboardService = new DashBoardServiceImpl();
        
        String userLastLogin = dashboardService.getUserLastLogin(userId);
        Long totalUsers = dashboardService.getTotalUsers();
        Long totalActiveUsers = dashboardService.getTotalUsersByStatus("active");
        Long totalInactiveUsers = dashboardService.getTotalUsersByStatus("inactive");
        List<UserModel> latestRegistrations = dashboardService.getLatestRegistrations(10);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("userLastLogin",userLastLogin);
        session.setAttribute("totalUsers",totalUsers);
        session.setAttribute("totalActiveUsers",totalActiveUsers);
        session.setAttribute("totalInactiveUsers",totalInactiveUsers);
        session.setAttribute("latestRegistrations",latestRegistrations);
        
        response.sendRedirect("dashboard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
