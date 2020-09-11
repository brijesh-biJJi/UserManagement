<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/forgotpassword.css">
</head>
<body>
<div class="forgotcard">
	<div class="cardd">
		<img class="img-circle" src="${pageContext.request.contextPath}/img/mi.jpg"  />
		<h3><span id="lblCompanyName" class="control-label">User Management</span></h3>
		
		<br>
		<p class="lead">Recover Password</p>
		
		<p class="text-center alert alert-info margin-bottom-30">Please enter your email address below to receive the password at your registered email.</p>
	
		<form action="ForgotServlet" method="post">
				<div class="form-group">
					<input name="email" class="form-control" type="email" id="email"  pattern="^[a-zA-Z0-9]+([._+-][0-9a-zA-Z]+)*@[a-zA-Z0-9]+\.[a-zA-Z]{2,4}([.][a-zA-Z]{2,3})?$" placeholder="Email" required>
				</div>
				<input type="submit" name="btnRecoverPassword" value="RECOVER PASSWORD" id="btnRecoverPassword" class="btn btn-primary btn-lg btn-block">
				<div class="bottom">
                    <span class="helper-text">Know your password? <a href="login">Login</a></span>
                </div>
		</form>
		</div>
	</div>
</div>


</body>
</html>