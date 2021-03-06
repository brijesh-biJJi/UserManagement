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
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/css/dropify.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toolbar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/newusers.css">
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
            			New User
            		</div>
            		<div class="heading-right">
	                    <a href="dashboard"><i class="fa fa-home"></i>Home&nbsp; </a>
	                    <span> / &nbsp; New User </span>
                	</div>
        		</div>
        		<form id="user-form" class="user-form" action="newuser" method="post" onsubmit="return validatePassword(this)">
        		<div class="container-fluid">
            		<div class="row">
               			<div class="col-md-8">
                    		<div class="panel panel-headline">
                        		<div class="panel-heading">
                            		<h3 class="panel-title">General</h3>
                            		<p class="panel-subtitle"></p>
                        		</div>
                        		<div class="panel-body">
                            		<div class="row">
                                		<div class="col-md-4 col-sm-6 col-xs-12">
                                    		<div class="form-group">
                                        		<label for="f_name" class="control-label">First Name</label>
                                        		<input name="f_name" type="text" id="f_name" required pattern="^[a-zA-Z ]{3,40}$"  tabindex="1" class="form-control" title="The first name must be more than 3 and less than 40 characters long.">
                                    		</div>
                                		</div>
		                                <div class="col-md-4 col-sm-6 col-xs-12">
		                                    <div class="form-group">
		                                        <label for="txtMiddleName" class="control-label">Middle Name</label>
		                                        <input name="m_name" type="text" id="m_name" tabindex="2" class="form-control">
		                                    </div>
		                                </div>
		                                <div class="col-md-4 col-sm-6 col-xs-12">
		                                    <div class="form-group">
		                                        <label for="txtLastName" class="control-label">Last Name</label>
		                                        <input name="l_name" type="text" id="l_name" placeholder=" " required pattern="^[a-zA-Z ]{3,40}$" tabindex="3" class="form-control"  title="The last name must be more than 3 and less than 40 characters long.">
		                                    </div>
		                                </div>
                            		</div>
                            		<div class="row">
                                		<div class="col-md-4 col-sm-6 col-xs-12">
                                    		<div class="form-group">
                                        		<label for="txtDob" class="control-label">Date of Birth</label>
                                        		<div class="input-group date" id="dtpDob">
                                            		<input name="dob" type="date" id="dob" tabindex="4" class="form-control" placeholder="" required >
                                            		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        		</div>
                                    		</div>
                                		</div>
                                		<div class="col-md-4 col-sm-6 col-xs-12">
                                    		<div class="form-group">
                                        		<label for="ddlGender" class="control-label">Gender</label>
                                        		<select name="gender" id="gender" tabindex="-1" class="form-control">
													<option value="" disabled selected>--- Select ---</option>
													<option value="Male">Male</option>
													<option value="Female">Female</option>
												</select>
											</div>
                                		</div>
                                		<div class="col-md-4 col-sm-6 col-xs-12">
                                    		<div class="form-group">
                                        		<label for="ddlCountry" class="control-label">Country</label>
                                        			<select name="country" id="country" tabindex="-1" class="form-control"  style="width:100%;" >
														<option value="" disabled selected>--- Select ---</option>
														<option value="India">India</option>
														<option value="Kuwait">Kuwait</option>
														<option value="Germany">Germany</option>
														<option value="Sri Lanka">Sri Lanka</option>
														<option value="South Africa">South Africa</option>
														<option value="Singapore">Singapore</option>
														<option value="US">United States</option>
														<option value="UAE">United Arab Emirates</option>
														<option value="Turkey">Turkey</option>
														<option value="Japan">Japan</option>
													</select>
                                    		</div>
                                		</div>
                            		</div>
                            		<div class="row">
                                		<div class="col-md-4 col-sm-6 col-xs-12">
                                    		<div class="form-group">
                                        		<label for="txtPhone" class="control-label">Phone</label>
                                        		<input name="phon" type="text" id="phon" tabindex="7" class="form-control" pattern="^\d{10}$" required title="Mobile number must contain 10 digit">
                                        		<span class="help-block">(999) 999-9999</span>
                                    		</div>
                                		</div>
                                		<div class="col-md-4 col-sm-6 col-xs-12">
                                    		<div class="form-group">
                                        		<label for="txtPhoneExt" class="control-label">Phone + Ext</label>
                                        		<input name="phoneExt" type="text" id="phoneExt" tabindex="8" class="form-control">
                                        		<span class="help-block">(999) 999-9999 99</span>
                                    		</div>
                                		</div>
                            		</div>
		                            <div class="row">
		                                <div class="col-md-4 col-sm-6 col-xs-12">
		                                    <div class="form-group">
		                                        <label for="txtEmail" class="control-label">Email</label>
		                                        <input name="email" type="email" id="email" tabindex="9" class="form-control" required pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" >
		                                    </div>
		                                </div>
		                                <div class="col-md-4 col-sm-6 col-xs-12">
		                                    <div class="form-group">
		                                        <label for="txtAddress" class="control-label">Address</label>
		                                        <textarea name="address" rows="5" cols="20" id="address" tabindex="10" class="form-control" title="The address should not be more than 200 characters long."></textarea>
		                                    </div>
		                                </div>
		                            </div>
                            		<hr>
		                            <div class="row">
		                                <div class="col-md-4 col-sm-6 col-xs-12">
		                                    <div class="form-group">
		                                        <label for="txtUsername" class="control-label">Username</label>
		                                        <input name="username" type="text" id="username" tabindex="11" class="form-control" title="The username must be more than 6 and less than 30 characters long.">
		                                    </div>
		                                </div>
		                                <div class="col-md-4 col-sm-6 col-xs-12">
		                                    <div class="form-group">
		                                        <label for="txtPassword" class="control-label">Password</label>
		                                        <div class="hideShowPassword-wrapper" style="position: relative; display: block; vertical-align: baseline; margin: 0px;">
		                                        <input name="password" type="password" id="password" required tabindex="12" class="form-control password hideShowPassword-field" title="The password and it's confirm are not the same" style="margin: 0px; padding-right: 49px;"><button type="button" role="button" aria-label="Show Password" title="Show Password" tabindex="0" class="hideShowPassword-toggle hideShowPassword-toggle-show" aria-pressed="false" style="position: absolute; right: 0px; top: 50%; margin-top: -10.5px;">Show</button></div>
		                                    </div>
		                                </div>
		                                <div class="col-md-4 col-sm-6 col-xs-12">
		                                    <div class="form-group">
		                                        <label for="txtConfirmPassword" class="control-label">Confirm Password</label>
		                                        <input name="confirmPassword" type="password" id="confirmPassword" required tabindex="13" class="form-control"   title="The password and it's confirm are not the same">
		                                    </div>
		                                </div>
		                                <br /><span id="error-message"></span>
		                            </div>
                            		<div class="row">
                                		<div class="col-md-4 col-sm-6 col-xs-12">
                                    		<div class="form-group">
                                        		<label for="ddlUserRole" class="control-label">User Role</label>
                                        		<select name="role" id="role" tabindex="14" class="form-control" required onchange="setPermissions();" title="Choose any user role.">
													<option value="">--- Select ---</option>
													<option value="admin">Admin</option>
													<option value="user">User</option>

												</select>
                                    		</div>
                                		</div>
                                		<div class="col-md-4 col-sm-6 col-xs-6">
                                    
                                		</div>
                                		<div class="col-md-4 col-sm-6 col-xs-6">
                                    
                                		</div>
                            		</div>
                        		</div>
                    		</div>
                		</div>
                		<div class="col-md-4">
                			<div class="panel panel-headline">
                        		<div class="panel-heading">
                            		<h3 class="panel-title">Photo</h3>
                            		<p class="panel-subtitle"></p>
                        		</div>
	                        	<div class="panel-body">
	                            	<label class="control-label">Acceptable image formats are jpg, jpeg, png & gif.</label>
	                            	<label class="control-label">Maximum image size allowed is 2MB.</label>
	                            	<input type="file" class="dropify" data-show-loader="true" data-show-remove="true" data-allowed-file-extensions="png jpeg jpg gif" data-errors-position="inside" data-max-file-size="2M" name="user-profile">
	                        	</div>
	                        </div>
                		</div>
            		</div>
        			
        			<div class="row">
                		<div class="col-md-12">
                    		<div id="permissions" class="panel panel-headline">
                        		<div class="panel-heading">
                            		<h3 class="panel-title">Permissions</h3>
                            		<p class="panel-subtitle"></p>
                        		</div>
                        		<div class="panel-body">
                            		<div class="table-responsive">
										<table class="table table-hover" cellspacing="0"  style="width:100%;border-collapse:collapse;">
											<thead>
												<tr>
													<!-- <th scope="col">
                                            			<table style="width: 100%;">
                                                			<thead>
                                                    			<tr> -->
                                                        			<th style="width: 60%">Web Page</th>
                                                        			<th style="width: 10%">
	                                                            		<div class="fancy-checkbox">
	                                                                		<label>
	                                                                    		<input class="admin-permission add" name="addPermission"  type="checkbox" id="addPermission" onchange="checkAll(this);">
	                                                                    		<span>Add</span>
	                                                                		</label>
	                                                            		</div>
                                                        			</th>
			                                                        <th style="width: 10%">
			                                                            <div class="fancy-checkbox">
			                                                                <label>
			                                                                    <input class="admin-permission delete" name="deletePermission" type="checkbox" id="deletePermission" onchange="checkAll(this);"">
			                                                                    <span>Delete</span>
			                                                                </label>
			                                                            </div>
			                                                        </th>
			                                                        <th style="width: 10%">
			                                                            <div class="fancy-checkbox">
			                                                                <label>
			                                                                    <input class="admin-permission modify" name="modifyPermission" type="checkbox" id="modifyPermission" onchange="checkAll(this);">
			                                                                    <span>Modify</span>
			                                                                </label>
			                                                            </div>
			                                                        </th>
			                                                        <th style="width: 10%">
			                                                            <div class="fancy-checkbox">
			                                                                <label>
			                                                                    <input class="admin-permission read" name="readPermission" type="checkbox" id="readPermission" onchange="checkAll(this);">
			                                                                    <span>Read</span>
			                                                                </label>
			                                                            </div>
			                                                        </th>
                                                    			<!-- </tr>
                                                			</thead>
                                            			</table>
                                        			</th> -->
												</tr>
											</thead>
											<tbody>
												<tr>
													<!-- <td>
                                            			<table style="width: 100%;">
                                                			<tbody>
                                                				<tr> -->
                                                    				<td style="width: 60%">
	                                                        			<span  class="inputLabel">Dashboard</span>
	                                                        			<input type="hidden" value="1">
                                                    				</td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input  type="checkbox" value="true" name="dash-add" id="dash-add" class="admin-permission add">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input  type="checkbox" value="true" name="dash-delete"  id="dash-delete" class="admin-permission delete">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input type="checkbox" value="true" name="dash-modify" id="dash-modify" class="admin-permission modify">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input  type="checkbox" value="true" name="dash-read" id="dash-read" class="admin-permission read" >
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
                                                				<!-- </tr>
                                            				</tbody>
                                            			</table>
                                        			</td> -->
												</tr>
												<tr>
													<!-- <td>
                                            			<table style="width: 100%;">
                                                			<tbody>
                                                				<tr> -->
                                                    				<td style="width: 60%">
                                                        				<span  class="inputLabel">Settings</span>
                                                        				<input type="hidden"   value="5">
                                                    				</td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input  type="checkbox" value="true" name="settings-add" id="settings-add" class="admin-permission add">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input  type="checkbox" value="true" name="settings-delete" id="settings-delete" class="admin-permission delete">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input type="checkbox" value="true" name="settings-modify" id="settings-modify" class="admin-permission modify">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input type="checkbox" value="true" name="settings-read" id="settings-read" class="admin-permission read">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
                                                					<!-- </tr>
                                            					</tbody>
                                           					</table>
                                        				</td> -->
												</tr>
												<tr>
													<!-- <td>
                                            			<table style="width: 100%;">
                                                			<tbody>
                                                				<tr> -->
                                                    				<td style="width: 60%">
				                                                        <span class="inputLabel">Users Information</span>
				                                                        <input type="hidden"  value="6">
                                                    				</td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input  type="checkbox" value="true" name="userinfo-add" id="userinfo-add" class="admin-permission add">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input type="checkbox" value="true" name="userinfo-delete" id="userinfo-delete" class="admin-permission delete">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input type="checkbox" value="true" name="userinfo-modify" id="userinfo-modify" class="admin-permission user-permission modify">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
				                                                    <td style="width: 10%">
				                                                        <div class="fancy-checkbox">
				                                                            <label>
				                                                                <input  type="checkbox" value="true" name="userinfo-read" id="userinfo-read" class="admin-permission read">
				                                                                <span>&nbsp;</span>
				                                                            </label>
				                                                        </div>
				                                                    </td>
                                                				<!-- </tr>
                                            				</tbody>
                                            			</table>
                                        			</td> -->
												</tr>
												<tr>
												<!-- <td>
                                            		<table style="width: 100%;">
                                                		<tbody>
                                                			<tr> -->
                                                    			<td style="width: 60%">
			                                                        <span class="inputLabel">Web Page 1</span>
			                                                        <input type="hidden" value="2">
                                                    			</td>
			                                                    <td style="width: 10%">
			                                                        <div class="fancy-checkbox">
			                                                            <label>
			                                                                <input  type="checkbox" value="true"name="wp1-add" id="wp1-add" class="admin-permission user-permission add">
			                                                                <span>&nbsp;</span>
			                                                            </label>
			                                                        </div>
			
			                                                    </td>
			                                                    <td style="width: 10%">
			                                                        <div class="fancy-checkbox">
			                                                            <label>
			                                                                <input type="checkbox" value="true" name="wp1-delete" id="wp1-delete" class="admin-permission delete">
			                                                                <span>&nbsp;</span>
			                                                            </label>
			                                                        </div>
			
			                                                    </td>
			                                                    <td style="width: 10%">
			                                                        <div class="fancy-checkbox">
			                                                            <label>
			                                                                <input  type="checkbox" value="true" name="wp1-modify" id="wp1-modify" class="admin-permission user-permission modify">
			                                                                <span>&nbsp;</span>
			                                                            </label>
			                                                        </div>
			                                                    </td>
			                                                    <td style="width: 10%">
			                                                        <div class="fancy-checkbox">
			                                                            <label>
			                                                                <input  type="checkbox" value="true" name="wp1-read" id="wp1-read" class="admin-permission user-permission read">
			                                                                <span>&nbsp;</span>
			                                                            </label>
			                                                        </div>
			                                                    </td>
                                                			<!-- </tr>
                                            			</tbody>
                                            		</table>
                                        		</td> -->
											</tr>
											<tr>
												<!-- <td>
                                            		<table style="width: 100%;">
                                                		<tbody><tr> -->
                                                    		<td style="width: 60%">
		                                                        <span  class="inputLabel">Web Page 2</span>
		                                                        <input type="hidden" value="3">
		                                                    </td>
		                                                    <td style="width: 10%">
		                                                        <div class="fancy-checkbox">
		                                                            <label>
		                                                                <input type="checkbox" value="true" name="wp2-add" id="wp2-add" class="admin-permission user-permission add">
		                                                                <span>&nbsp;</span>
		                                                            </label>
		                                                        </div>
		
		                                                    </td>
		                                                    <td style="width: 10%">
		                                                        <div class="fancy-checkbox">
		                                                            <label>
		                                                                <input  type="checkbox" value="true" name="wp2-delete" id="wp2-delete" class="admin-permission delete" >
		                                                                <span>&nbsp;</span>
		                                                            </label>
		                                                        </div>
		
		                                                    </td>
		                                                    <td style="width: 10%">
		                                                        <div class="fancy-checkbox">
		                                                            <label>
		                                                                <input  type="checkbox" value="true" name="wp2-modify" id="wp2-modify" class="admin-permission user-permission modify">
		                                                                <span>&nbsp;</span>
		                                                            </label>
		                                                        </div>
		                                                    </td>
		                                                    <td style="width: 10%">
		                                                        <div class="fancy-checkbox">
		                                                            <label>
		                                                                <input  type="checkbox" value="true" name="wp2-read" id="wp2-read" class="admin-permission user-permission read">
		                                                                <span>&nbsp;</span>
		                                                            </label>
		                                                        </div>
		                                                    </td>
                                                		<!-- </tr>
                                            		</tbody>
                                            	</table>
                                        	</td> -->
										</tr>
										<tr>
											<!-- <td>
                                            	<table style="width: 100%;">
                                                	<tbody>
                                                		<tr> -->
		                                                    <td style="width: 60%">
		                                                        <span  class="inputLabel">Web Page 3</span>
		                                                        <input type="hidden" value="4">
		                                                    </td>
		                                                    <td style="width: 10%">
		                                                        <div class="fancy-checkbox">
		                                                            <label>
		                                                                <input type="checkbox" value="true" name="wp3-add" id="wp3-add" class="admin-permission user-permission add" >
		                                                                <span>&nbsp;</span>
		                                                            </label>
		                                                        </div>
		
		                                                    </td>
		                                                    <td style="width: 10%">
		                                                        <div class="fancy-checkbox">
		                                                            <label>
		                                                                <input type="checkbox" value="true" name="wp3-delete" id="wp3-delete" class="admin-permission delete">
		                                                                <span>&nbsp;</span>
		                                                            </label>
		                                                        </div>
		
		                                                    </td>
		                                                    <td style="width: 10%">
		                                                        <div class="fancy-checkbox">
		                                                            <label>
		                                                                <input type="checkbox" value="true" name="wp3-modify" id="wp3-modify" class="admin-permission user-permission modify">
		                                                                <span>&nbsp;</span>
		                                                            </label>
		                                                        </div>
		                                                    </td>
		                                                    <td style="width: 10%">
		                                                        <div class="fancy-checkbox">
		                                                            <label>
		                                                                <input type="checkbox" value="true" name="wp3-read" id="wp3-read" class="admin-permission user-permission read">
		                                                                <span>&nbsp;</span>
		                                                            </label>
		                                                        </div>
		                                                    </td>
                                                		<!-- </tr>
                                            		</tbody>
                                            	</table>
                                        	</td> -->
										</tr>
									</tbody>
								</table>
								</div>
                       			</div>
                        		
                   			</div>
               			</div>
            		</div>
					
					<div class="row" style="padding: 10px 0">
                		<div class="col-md-12 text-center">
                    		<input type="submit" name="btnSubmit" value="Submit" id="btnSubmit" tabindex="17" class="btn btn-primary">
                    		<span></span>
                    		<input id="btnReset" type="button" class="btn btn-outline-secondary" value="Reset" onclick="resetFunction();">
                		</div>
            		</div>        		
        		</div>
        		</form>
				
				<footer>
                <div class="container-fluid" style="display: flex; justify-content: flex-end; padding: 10px 20px; margin-top: 10px ">
                    
				<p class="copyright" >
   					�
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
<script>
function resetFunction() {
  document.getElementById("user-form").reset();
}


function validatePassword(event) {
	var pass = event.password.value;
	var cpass =event.confirmPassword.value;
	if (pass != cpass) {
		document.getElementById('error-message').innerHTML = "Password did not match";
		return false;
	} else {
		return true;
	}
}
</script>
</body>
</html>