<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toolbar.css">
</head>
<body>
	<nav class="navbar">
			<div class="left-area"> 
			<span id="lblCompanyName" class="custom-font">User Management</span>
			<i id="sideBarIcon" class='ti-arrow-circle-left' onclick="sideBarBtn()"></i>
			</div>
			<div class="right-area" onclick="dropdown('dropdown-list')">
				<div class="dropdown">
					<span class="dropbtn"><img src="" alt=""/> admin</span>
					<div id="dropdown-list" class="dropdown-content">
		   				<span class="profile"><a href="profile"><i class='ti-user'></i> Profile</a></span>
		    			<span class="logout"><a href="logout"><i class='ti-power-off'></i> Logout</a></span>
		  			</div>
				</div>
			</div>
		</nav>
</body>
</html>