<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Management</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css">
</head>
<body>
	<div class="sidebar" id="sidebarId">
					
					<a href="#" id="dashboard-id">
						<i class="ti-dashboard"> </i>
						<span>Dashboard </span>
						<span class="label label-success">UPDATED</span>
					</a>
					
				    <button class="menu-btn"><i class="ti-files"></i>  WebPages
				        <i class="icon-submenu ti-angle-left"></i>
				    </button>
				    <div class="sub-menu">
				        <a href="#">WebPage  1</a>
				        <a href="#">WebPage  2</a>
				        <a href="#">WebPage  3</a>
				        <a href="#">Blank Page</a>
				    </div>
				    <button class="menu-btn" id="user-id"><i class="ti-user"> </i>Users
				        <i class="icon-submenu ti-angle-left"></i>
				    </button>
				    <div class="sub-menu">
				        <a href="newuserinfo">New User</a>
				        <a href="userdetails">Users List</a>
				    </div>
					
					<div>
						<a href="profile"> <i class="ti-id-badge"></i> <span>Profile</span>
						</a>
					</div>
					
					<button class="menu-btn" ><i class="ti-settings"></i> </i>Settings
				        <i class="icon-submenu ti-angle-left"></i>
				    </button>
				    <div class="sub-menu">
	                    <a href="#">Authentication</a>
	                    <a href="#">Email SMTP</a>
	                    <a href="#">Database Connection</a>
				    </div>
					
					<div>
						<a href="logout"> <i class="ti-power-off"></i> <span>Logout</span>
						</a>
					</div>
					<div class="toggle">
							<i class="ti-arrows-horizontal"></i>
					</div>
			</div>
</body>
</html>