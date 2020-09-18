<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Management</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toolbar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/newusers.css">
</head>
<body>
<%
	response.setHeader("Cache-Control","no-chache,no-store,must-revalidate");//HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0);
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
	<div id="wrapper">
		<!-- NAVBAR -->
		<%@include file="toolbar.jsp"%>
		<!--END NAVBAR -->
		<div class="body-content">
			<!-- LEFT SIDEBAR -->
			<%@include file="sidebar.jsp"%>
			<!--END LEFT SIDEBAR -->	
			
			<!--MAIN -->
			<div class="main-content" style="margin-bottom: 50px; padding-bottom: 50px">
				<div class="content-heading">
            		<div class="heading-left">
            			Users
            		</div>
            		<div class="heading-right">
	                    <a href="dashboard"><i class="fa fa-home"></i>Home&nbsp; </a>
	                    <span> / &nbsp; Users </span>
                	</div>
        		</div>
        		
        		<div class="container-fluid">
            		<div class="row">
               			<div class="col-md-12">
                    		<div class="panel panel-headline">
                        		<div class="panel-heading">
                            		<h3 class="panel-title"></h3>
                            		<p class="panel-subtitle"></p>
                            		<h3 class="panel-title">
                        			<span id= class="panel-title"></span></h3>
                        		</div>
                        		<div class="panel-body">
                            		
                            	
                            		
		                            
                                		
                            	</div>
                        		
                    		</div>
                		</div>
                		
            		</div>						
        		</div>
        		
				
				<footer>
                <div class="container-fluid" style="display: flex; justify-content: flex-end; padding: 10px 20px; margin-top: 10px ">
                    
				<p class="copyright" >
   					©
    			<script type="text/javascript">document.write(new Date().getFullYear())</script>2020
    			<a href="https://codecanyon.net/user/mimtiyaz" target="_blank">mimtiyaz - CodeCanyon</a>
				</p>

                </div>
            </footer>
			</div>
			<!--END MAIN -->
			
			
		</div>
	</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
<script type="text/javascript" src ="${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript" src ="${pageContext.request.contextPath}/js/permision.js"></script>	
</body>
</html>