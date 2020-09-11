<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="css/login.css">
</head>
<body>

 	
	<div class="container" style="display:flex; align-items:center; justify-content:center" class="card text-center">
		<div style="display:flex; align-items:center; justify-content:center" class="card text-center">
           <div class="card-body">
           <div>${notify}</div>
			 	<div  class="row">
					<div style="padding:10px;" class="col-md-6">
					
                        <div class="text-center">
                              <img class="img-circle img-thumbnail img-responsive" src="http://www.ittutorials.in/images/mi-logo.jpg" alt="User Management">
                        </div>
                        <p class="lead">Login to your account</p> 
                                
                		<form action="loginServlet" method="post">
                 
	                  		<div class="form-group">
	                    		<input type="email" name="email" class="form-control form-control-lg" placeholder="username">
	                  		</div>
	                  		<div class="form-group">
	                    		<input type="password" name="pass" class="form-control form-control-lg" placeholder="password">
	                  		</div>
	                		
							<!-- Default checked -->
						<div class="custom-control custom-switch">
						  <input type="checkbox" class="custom-control-input" id="customSwitch1" checked>
						  <label class="custom-control-label" for="customSwitch1">Remember Me</label>
						</div>
	                		
	                  			<input type="submit" value="LOGIN" class="btn  btn-primary btn-lg btn-block">
                		</form>
                        <br>
                        <div id="divForgotPassword" class="bottom">
                              <span class="helper-text"><i class="fa fa-lock"></i>&nbsp;<a href="forgotpassword">Forgot password?</a></span>
                        </div>
                          
					</div>
					<div style="background: rgba(99, 156, 185, 0.92);margin:0;padding:0;background-image: url(img/login-bg.jpg);" class="col-md-6 right">
                            <div class="content text" >
                               	<h1 class="heading"><span id="lblCompanyName">User Management</span></h1>
                                <p>Version 2.2</p>
                            </div>
                            
                  	</div>
				</div>
				</div>
				</div>
			</div>
		</div> 



</body>
</html>