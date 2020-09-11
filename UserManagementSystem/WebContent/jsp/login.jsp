<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
    crossorigin="anonymous">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div class="cardd">
	<div class="left">
		<div class="contain">
		<img class="img-circle" src="${pageContext.request.contextPath}/img/mi.jpg"  />
		</div>
		<h4 class="contain"><span id="lblCompanyName" class="control-label">Login to your account</span></h4>
		
		<form action="loginServlet" method="post">
        	<div class="form-group">
	        	<input type="email" name="email" class="form-control" placeholder="username">
	        </div>
	        <div class="form-group">
	            <input type="password" name="pass" class="form-control" placeholder="password">
	        </div>
	        
	        <!-- Default checked -->
			<div class="custom-control custom-switch contain">
				<input type="checkbox" class="custom-control-input" id="customSwitch1" checked>
				<label class="custom-control-label" for="customSwitch1">Remember Me</label>
			</div>
			
			<input type="submit" value="LOGIN" class="btn  btn-primary btn-lg btn-block">
      	</form>
      	
      	 <br>
         <div id="divForgotPassword" class="bottom contain">
             <span class="helper-text"><i class="fa fa-lock"></i>&nbsp;<a href="forgotpassword">Forgot password?</a></span>
         </div>
	</div>
	<div class="right">
		<div class="overlay"></div>
		<div class="content-text">
        	<h2 class="heading">User Management</h2>
            <p>Version 2.2</p>
        </div>
	</div>
</div>
</body>
</html>