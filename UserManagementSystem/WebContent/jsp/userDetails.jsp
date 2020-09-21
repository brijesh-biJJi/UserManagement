<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.bridgelabz.usermanagement.model.UserModel"%>
<%@ page import="java.util.*" %>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/userDetails.css">
</head>
<body>
<%
	response.setHeader("Cache-Control","no-chache,no-store,must-revalidate");//HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0);
	if(session.getAttribute("username")==null)
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
				                    <h3 class="panel-title">
				                        <span class="panel-title"></span>
				                    </h3>
				                    <div class="right">
				                        <a href="newuserinfo" class="btn btn-info btn-xs">
				                            <i class="ti-user"></i>
				                            <span>New User</span>
				                        </a>
				                    </div>
				                </div>
                        		<div class="panel-body">
                            		<div class="row" style="display: flex; justify-content: space-between; flex-wrap: nowrap;">
				                        <div class="col-md-2 col-xs-4">
				                            <select id="pageSize" class="form-control btn-panel-refresh" onchange="changePagesize(this);">
				                                <option>10</option>
				                                <option>20</option>
				                                <option>50</option>
				                                <option>100</option>
				                            </select>
				                        </div>
				                        <div class="col-md-3 col-xs-8 pull-right">
				                            <input name="txtSearch" type="text" id="searchInput" onkeyup="searchFunction()" class="form-control" placeholder="Search...">
				                        </div>
                    				</div>	
                    				<div style="margin: 30px 0"></div>
                    				<div class="row">
                    					<div class="col-md-12 table-responsive">
                    						<table id="usersTable" class="table table-bordered table-hover" cellspacing="0" style="width: 100%; border-collapse: collapse;">
                    							<thead>
                    								<tr>
                    									<th scope="col">&nbsp;</th>
                    									<th scope="col">Name</th>
                    									<th scope="col">Email</th>
                    									<th scope="col">DOB</th>
                    									<th scope="col">Status</th>
                    									<th scope="col">Role</th>
                    									<th scope="col">Account</th>
                    									<th scope="col">Action</th>
                    								</tr>
                    							</thead>
                    							<tbody>	
                    								<%List<UserModel> usersList= (List<UserModel>) session.getAttribute("usersList"); 
                        								for (UserModel user: usersList) { 
                        							%>
                        							<tr>
                        								<td align="center" valign="middle" style="width:4%;">
                                            				<input type="hidden" >
                                           	 				<img id="userImg" class="img-rounded" style="width: 38px; height: 38px; margin-top: -10px; margin-bottom: -12px" alt="" src="${pageContext.request.contextPath}/img/user.png">
                                        				</td>
                                        				<td><%=user.getFirst_name()+ " " + user.getLast_name()%></td>
														<td><%=user.getEmail()%></td>
														<td><%=user.getDob()%></td>
														<td style="display: flex; justify-content: center;" >
															<% 
																if (user.getStatus().equals("active")) {
															%> 
																<label id="lblStatus" style="font-size: 13px; font-weight: normal; text-align: center;" class="label label-success label-transparent">Active</label>
															<% 
																} else { 
															%> 
																<label id="lblStatus" style="font-size: 13px; font-weight: normal; text-align: center;" class="label label-danger label-transparent">Inactive</label>
															<% } %>
														</td>
														<td><%=user.getUser_role().toUpperCase()%></td>
														<td style="text-align: center;"><label style="font-weight: normal; font-size: large; color: #88BA40;"
																class="ti-unlock text-success">
														</label></td>
														<td align="center" style="width:8%;">
				                                            <a id="editUser" style="cursor: pointer; " data-user-id="1" title="Edit User Details">
				                                                <i class="ti-pencil-alt" style="font-size:medium ; color: #00aaff;"></i>
				                                            </a>
				                                            <a id="deleteUser" style="cursor: pointer;" data-user-id="1" title="Delete User Details" data-modelid="<%=user.getUser_id()%>">
				                                                <i class="ti-trash text-danger" style="font-size: medium"></i>
				                                            </a>
				                                            
				                   
																 <div id="<%=user.getUser_id()%>" class="modal-fade">
				  													<div class="dialog-box">
				                                                            <h5 style="margin-bottom: 1rem">Are you sure?</h5>
				                                                            <a id="deleteUserModal" href="DeleteUser?userid=<%=user.getUser_id()%>" class="btn btn-success" style="border-radius: 3px; padding: 6px 22px; background-color: #41B314;border-color: #3ca512;" data-user-id="1" data-dismiss="modal">Yes</a>
				                                                            <input type="button" class="btn btn-danger close-modal" style="border-radius: 3px; padding: 6px 22px; background-color: #F9354C;border-color: #f9263f;" data-dismiss="modal" value="No">                                                            
				  													</div>
																</div>
														</td>	
                        							</tr>
                        							<% } %>	
                    							</tbody>
                    						</table>
                    					</div>
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
<script type="text/javascript" src ="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>