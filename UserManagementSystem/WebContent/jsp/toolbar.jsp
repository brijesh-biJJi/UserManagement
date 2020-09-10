<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="../css/toolbar.css">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="brand">
	          <span id="lblCompanyName" class="custom-font">User Management</span>
	    </div>
		<div class="container-fluid">
                    <div id="tour-fullwidth" class="navbar-btn">
                        <button type="button" class="btn-toggle-fullwidth"><i class="ti-arrow-circle-left"></i></button>
                    </div>
                    <div id="navbar-menu">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src='/ImageHandler.ashx?user_id_pk=65' alt="" />
                                    <span>
                                        <span id="lblUsername">admin</span></span>
                                </a>
                                <ul class="dropdown-menu logged-user-menu">
                                    <li>
                                        <a id="aProfile" href="#"><i class='ti-user'></i><span>Profile</span></a>
                                    </li>
                                    <li><a href='/logout.jsp'><i class="ti-power-off"></i><span>Logout</span></a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
	
	</nav>
</body>
</html>