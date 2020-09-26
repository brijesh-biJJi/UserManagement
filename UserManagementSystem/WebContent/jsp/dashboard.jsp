<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.bridgelabz.usermanagement.model.UserModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Management</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/css/dropify.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toolbar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
</head>
<body>
 <%
	response.setHeader("Cache-Control","no-chache,no-store,must-revalidate");//HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0);
	if(session.getAttribute("user")==null)
	{
		response.sendRedirect("login");
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
            			<h1 class="page-title">Welcome ${user.getUsername()}</h1>
            			<p class="page-subtitle">
		                    You last logged in on: ${userLastLogin}
                		</p>
            		</div>
            		<div class="heading-right">
	                    <a href="dashboard"><i class="fa fa-home"></i>Home&nbsp; </a>
	                    <span> / &nbsp; Dashboard </span>
                	</div>
        		</div>
        		
        		<div class="container-fluid">
            		<div class="row">
		                <div class="col-md-3 col-sm-6 col-xs-12">
		                    <a href="#">
		                        <div class="boxes box_1 animate">
		                            <span class="icon-wrapper custom-bg-blue">
		                            	<i class="ti-user">
		                            </i></span>
		                            <div class="right">
		                                <span class="title"><b>TOTAL</b></span>
		                                <span class="value">
		                                    <span id="totalUsers">${totalUsers}</span></span><br>
		                            </div>
		                        </div>
		                    </a>
		                </div>
		                <div class="col-md-3 col-sm-6 col-xs-12">
		                    <a href="#">
		                        <div class="boxes box_1 animate">
		                            <span class="icon-wrapper custom-bg-green2"><i class="ti-check"></i></span>
		                            <div class="right">
		                                <span class="title"><b>ACTIVE</b></span>
		                                <span class="value">
		                                    <span id="activeUsers">${totalActiveUsers}</span></span><br>
		                            </div>
		                        </div>
		                    </a>
		                </div>
		                <div class="col-md-3 col-sm-6 col-xs-12">
		                    <a href="#" >
		                        <div class="boxes box_1 animate">
		                            <span class="icon-wrapper custom-bg-red"><i class="ti-na"></i></span>
		                            <div class="right">
		                                <span class="title"><b>INACTIVE</b></span>
		                                <span class="value">
		                                    <span id="inactiveUsers">${totalInactiveUsers}</span></span><br>
		                            </div>
		                        </div>
		                    </a>
		                </div>
		                <div class="col-md-3 col-sm-6 col-xs-12">
		                    <div class="boxes box_1 animate">
		                        <span class="icon-wrapper custom-bg-yellow"><i class="ti-eye"></i></span>
		                        <div class="right">
		                            <span class="title"><b>ONLINE</b></span>
		                            <span class="value">
		                                <span id="onlineUsers">1</span></span>
		                        </div>
		                    </div>
		                </div>
		            </div>
        			
        			
					<div class="row sortable-grid">
		                <div class="col-md-8 sortable-item">
		
		                    <div id="pnlRegistrationHistory"  class="panel panel-sidebar sidebar-right">
		                        <div class="panel-heading">
		                            <h3 class="panel-title">
		                                <label id="lblRegistrationHistory">All Time Registration History</label></h3>
		                        </div>
		                        <div class="panel-body">
		                            <div class="left">
		                                <div class="row">
		                                    <div class="col-md-12">
		                                        <button type="button" class="btn btn-sm btn-info"  id="btnAllTime" title="Users registered since the beginning.">All Time</button>
		                                        <button type="button" class="btn btn-sm btn-info"  id="btnCurrentYear" title="Users registered during the current year.">2020</button>
		                                        <button type="button" class="btn btn-sm btn-info"  id="btnCurrentMonth" title="Users registered during the current month.">September</button>
		                                    </div>
		                                </div>
		                                
		                            </div>
		                            <div class="right">
		                               
		                                
		                            </div>
		                        </div>
		                    </div>
		                    
		                </div>
		                <div class="col-md-4 sortable-item">
		                    <div id="pnlLatestRegistration" class="panel panel-scrolling">
		                        <div class="panel-heading">
		                            <h4 class="panel-title">Latest Registration</h4>
		                            <div class="right"  style="float: right;height: 25px">
		                                <span class="link"><a href="#">Load More</a></span>
		                            </div>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/js/dropify.min.js"></script>
<script type="text/javascript" src ="${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript" src ="${pageContext.request.contextPath}/js/permision.js"></script>	

</body>
</html>   