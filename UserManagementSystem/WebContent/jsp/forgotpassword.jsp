<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="../css/forgotpassword.css">
</head>
<body>
<div id="wrapper">
 <div class="verticle-align-wrap">
 <div class="verticle-align-middle">
                    <div class="auth-box forgot-password">
                        <div class="content">
                            <div class="header">
                                <div class="text-center">
                                    <img class="img-circle img-thumbnail img-responsive" src="http://www.ittutorials.in/images/mi-logo.jpg" alt="User Management">
                                    <h3><span id="lblCompanyName" class="control-label">User Management</span></h3>
                                </div>
                                <br>
                                <p class="lead">Recover Password</p>
                                <p class="text-center alert alert-info margin-bottom-30">Please enter your email address below to receive the password at your registered email.</p>
                            </div>
                            <div class="form-auth-small">
                            <form action="ForgotServlet" method="post">
                                <div class="form-group">
                                    <input name="txtEmail" type="text" id="txtEmail" class="form-control" placeholder="Email" data-bv-notempty="true" data-bv-notempty-message="The email is required." data-bv-emailaddress="true" data-bv-emailaddress-message="Invalid email address.">
                                </div>
                                <input type="submit" name="btnRecoverPassword" value="RECOVER PASSWORD" id="btnRecoverPassword" class="btn btn-primary btn-lg btn-block">
                                </form>
                                <div class="bottom">
                                    <span class="helper-text">Know your password? <a href="login.jsp">Login</a></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
                </div>
</div>
</body>
</html>