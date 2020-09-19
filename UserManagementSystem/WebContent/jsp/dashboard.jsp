<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
</head>
<body>
	<div class="dashboard">
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
		<div class="body-content">
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
				    </div>
				    <button class="menu-btn" id="user-id"><i class="ti-user"> </i>Users
				        <i class="icon-submenu ti-angle-left"></i>
				    </button>
				    <div class="sub-menu">
				        <a href="newuserinfo">New User</a>
				        <a href="userdetails">Users List</a>
				    </div>
					
				
					<div>
						<a href="logout"> <i class="ti-power-off"></i> <span>Logout</span>
						</a>
					</div>
					<div class="toggle">
							<i class="ti-arrows-horizontal"></i>
					</div>
			</div>
			<div class="main-content">
				<div class="boxes1">
					<div class="box">
					<h1>box 1</h1>
					<p>Lorem Ipsum is simply dummy text of the printing a and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
					</div>
					
					<div class="box">
					<h1>box 2</h1>
					<p>Lorem Ipsum is simply dto make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
					</div>
					<div class="box">
					<h1>box 3</h1>
					<p>Lorem Ipsum is simply dummy text of ndard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
					</div>
					<div class="box">
					<h1>box 4</h1>
					<p>Contrary to popular beli 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.
					</div>
				</div>
			
			</div>
		</div>
		
	</div>
	<script type="text/javascript" src ="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>   