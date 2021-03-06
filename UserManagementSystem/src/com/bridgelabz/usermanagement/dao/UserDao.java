package com.bridgelabz.usermanagement.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bridgelabz.usermanagement.model.ConnectionModel;
import com.bridgelabz.usermanagement.model.MailObject;
import com.bridgelabz.usermanagement.model.UserModel;
import com.bridgelabz.usermanagement.model.UserPermissions;
import com.bridgelabz.usermanagement.utility.MailServiceProvider;

public class UserDao {
	ConnectionModel conModel=new ConnectionModel();
	UserModel userModel=new UserModel();
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	MailObject mailObj=new MailObject();

	
	public Connection getConnection() {
		
		
		try {
			FileInputStream fis=new FileInputStream("F:\\UserManagement\\UserManagementSystem\\resources\\config.properties");
			
			Properties prop=new Properties();
			prop.load(fis);
			
			String driver=prop.getProperty("driver");
			conModel.setDburl(prop.getProperty("dburl"));
			conModel.setDbuser(prop.getProperty("dbuser"));
			conModel.setDbpass(prop.getProperty("dbpass"));
		
			
			Class.forName(driver);
			con=DriverManager.getConnection(conModel.getDburl(),conModel.getDbuser(),conModel.getDbpass());
			} 
			catch (ClassNotFoundException | SQLException | IOException e) {
				System.out.println(e.getMessage());
			}
			
			return con;
	}

	public ResultSet checkLogin(String email, String pass) {
		Connection con=getConnection();
		String qry="select * from user where email=? and password=?";
		
		userModel.setEmail(email);
		userModel.setPassword(pass);
		
		try {
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, userModel.getEmail());
			pstmt.setString(2, userModel.getPassword());
			
			rs=pstmt.executeQuery();
			return rs;

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return rs;

	}
	
	public int registerUser(UserModel u) {
		PreparedStatement ps = null;
		Connection con = null;
		String addQuery="insert into user(email,first_name,middle_name,last_name,phone,address,username,password,creator_at,dob,country,userrole,status,gender) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		  int status=0;  
	        try{  
	             con=getConnection();  
	            ps=con.prepareStatement(addQuery);
	            ps.setString(1,u.getEmail());
	            ps.setString(2, u.getFirst_name());
	            ps.setString(3, u.getMiddle_name());
	            ps.setString(4, u.getLast_name());
	            ps.setLong(5,u.getPhone());
	            ps.setString(6,u.getAddress());
	            ps.setString(7,u.getUsername());
	            ps.setString(8,u.getPassword());
	            ps.setString(9,u.getCreator_at());
	            ps.setString(10, u.getDob());
	            ps.setString(11, u.getCountry());
	            ps.setString(12, u.getUser_role());
	            ps.setString(13, u.getStatus());
	            ps.setString(14, u.getGender());
	            status=ps.executeUpdate();  
	            return status;  
	        }catch(Exception ex){ex.printStackTrace();}  
	        finally {
				if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
				
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	          
	        return status;  
	}
	
	
	

	 
	 public boolean passwordRecovery(String email) {
		 
			Connection con=getConnection();
			userModel.setEmail(email);
			String qry="select * from user where email=?";
			
			try {
				pstmt=con.prepareStatement(qry);
				pstmt.setString(1, userModel.getEmail());
				
				rs=pstmt.executeQuery();
				if(rs.next()) {
					
					String mailResponse= "Welcome "+rs.getString("first_name")+" "+rs.getString("last_name")
					+"\n We received an password recovery request on User Management for "+email
					+"\n Your username is "+rs.getString("username")
					+"\n Your password is "+rs.getString("password");
									
					System.out.println(mailResponse);
					
					mailObj.setEmail(email);
					mailObj.setSubject("Pasword Recovery Request");
					mailObj.setMessage(mailResponse);
					
					//rabbitMqSender.send(mailObj);
					MailServiceProvider.sendEmail(mailObj.getEmail(), mailObj.getSubject(), mailObj.getMessage());
					
					
					return true;

				}
						
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return false;
	 }
	 
	 public int getUserIdByEmail(String email) {
			String qry="select user_id from user where email=?";
			
			try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement(qry);  
	            ps.setString(1,email);   
	            ResultSet rs=ps.executeQuery(); 
	            if(rs.next())
	            	return rs.getInt(1);
	        }catch(Exception e)
			{e.printStackTrace();}
			return 0;  
	 }



	public int setPermission(int userId, boolean add_p, boolean delete_p, boolean modify_p, boolean read_p,
			int webpage_id) 
	{
		String qry= "insert into user_permissions(user_id,add_p,delete_p,modify_p,read_p,webpage_id) VALUES (?,?,?,?,?,?)";
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=getConnection();
			ps = con.prepareStatement(qry);
			ps.setInt(1, userId);
			ps.setBoolean(2, add_p);
			ps.setBoolean(3, delete_p);
			ps.setBoolean(4, modify_p);
			ps.setBoolean(5, read_p);
			ps.setInt(6, webpage_id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	public int deleteUser(int userid) {
		Connection con=null;
		PreparedStatement ps=null;
		String deleteUserQry="delete from user where user_id=?";
		String deleteUserPermissionQry="delete from user_permissions where user_id=?";
		int status=0;  
        try{  
             con=getConnection();  
             ps=con.prepareStatement(deleteUserPermissionQry);  
             ps.setInt(1,userid); 
             status=ps.executeUpdate();  
             if(status > 0) {
            	 ps=con.prepareStatement(deleteUserQry);  
                 ps.setInt(1,userid);  
                 status=ps.executeUpdate();  
             }
            return status;
        }catch(Exception e){e.printStackTrace();}  
        finally {
			if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        return status;  
	}

	public Long getTotalUsers() {
		String numberOfUsers = "select count(*) from user";
		Connection con=null;
		PreparedStatement ps=null; 
		 try{  
			 
			 con=getConnection(); 
			 ps=con.prepareStatement(numberOfUsers);  
			 ResultSet resultSet = ps.executeQuery();
	            if (resultSet.next()) {
	                return resultSet.getLong(1);
	            }
        }catch(Exception e){e.printStackTrace();}  
        finally {
			if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<UserModel> getUsersByPageSize(int start, int totalUserByPage) {
		 String getUsers = "select * from user limit ?,?";
		 Connection con=null;
		 PreparedStatement ps =null;
	        List<UserModel> usersList=new ArrayList<UserModel>();  
	        try {
	        	con=getConnection(); 
	            ps= con.prepareStatement(getUsers);
	            ps.setInt(1, start);
	            ps.setInt(2, totalUserByPage);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	UserModel u = new UserModel();  
	            	u.setUser_id(rs.getInt(1)); 
	                u.setEmail(rs.getString(2));
	                u.setFirst_name(rs.getString(3));  
	                u.setLast_name(rs.getString(5));  
	                u.setPhone(rs.getLong(6));
	                u.setAddress(rs.getString(7));
	                u.setUsername(rs.getString(8));
	                u.setDob(rs.getString(11));
	                u.setCountry(rs.getString(12));
	                u.setUser_role(rs.getString(13));
	                u.setStatus(rs.getString(14));
	                u.setGender(rs.getString(16));
	                usersList.add(u);  
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return usersList;
	}

	public UserModel getUserDetails(int userId) {
		String getUserQry="select * from user where user_id=?";
		Connection con=null;
		 PreparedStatement ps =null; 
		 UserModel u = new UserModel();  
	        try{  
	            con=getConnection();  
	            ps=con.prepareStatement(getUserQry);  
	            ps.setInt(1, userId);
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                u.setUser_id(rs.getInt(1)); 
	                u.setEmail(rs.getString(2));
	                u.setFirst_name(rs.getString(3));
	                u.setMiddle_name(rs.getString(4));
	                u.setLast_name(rs.getString(5));  
	                u.setPhone(rs.getLong(6));
	                u.setAddress(rs.getString(7));
	                u.setUsername(rs.getString(8));
	                u.setPassword(rs.getString(9));
	                u.setCpassword(rs.getString(10));
	                u.setDob(rs.getString(11));
	                u.setCountry(rs.getString(12));
	                u.setUser_role(rs.getString(13));
	                u.setStatus(rs.getString(14));
	                u.setGender(rs.getString(16));
	            }  
	            System.out.println("User Details in dao"+u);
	            return u;  
	        }catch(Exception e){e.printStackTrace();}  
	        finally {
				if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
				
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	          
	        return u;  
	}

	public List<Boolean> getUserPermissions(int userId, int webpageId) {
		String getUserPermissionsQry = "select * from user_permissions where user_id = ? and webpage_id = ?";
		List<Boolean> permissions = new ArrayList<>();
		Connection con=null;
		 PreparedStatement ps =null; 
		try {
			con=getConnection();
			ps = con.prepareStatement(getUserPermissionsQry);
			ps.setLong(1, userId);
			ps.setInt(2, webpageId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				permissions.add(rs.getBoolean(3));
				permissions.add(rs.getBoolean(4));
				permissions.add(rs.getBoolean(5));
				permissions.add(rs.getBoolean(6));
			}
			return permissions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}  

	
public int updateUser(int userId, UserModel u) {
	PreparedStatement ps = null;
	Connection con = null;
		String updateQuery="update user set email=?, first_name=?, middle_name=?, last_name=?, phone=?,address=?, username=?,password=?, dob=?, country=?, userrole=?, status=?, gender=? where user_id=?";
		    
	        try{  
	            con=getConnection();  
	            ps=con.prepareStatement(updateQuery);
	            ps.setString(1,u.getEmail());
	            ps.setString(2, u.getFirst_name());
	            ps.setString(3, u.getMiddle_name());
	            ps.setString(4, u.getLast_name());
	            ps.setLong(5,u.getPhone());
	            ps.setString(6,u.getAddress());
	            ps.setString(7,u.getUsername());
	            ps.setString(8,u.getPassword());
	            ps.setString(9, u.getDob());
	            ps.setString(10, u.getCountry());
	            ps.setString(11, u.getUser_role());
	            ps.setString(12, u.getStatus());
	            ps.setString(13, u.getGender());
	            ps.setInt(14,userId );
	            if(ps.executeUpdate() == 1)
					return 1;  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return 0;  
	}

public int updatePermission(int userId, boolean dashAdd, boolean dashDelete, boolean dashModify, boolean dashRead,
		int webpageid) {
	
	String qry= "update user_permissions set add_p=?, delete_p=?, modify_p=?, read_p=? where user_id=? and webpage_id=?";
	Connection con=null;
	PreparedStatement ps=null;
	try {
		con=getConnection();
		ps = con.prepareStatement(qry);
		ps.setBoolean(1, dashAdd);
		ps.setBoolean(2, dashDelete);
		ps.setBoolean(3, dashModify);
		ps.setBoolean(4, dashRead);
		ps.setInt(5, userId);
		ps.setInt(6, webpageid);
		return ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
}

public void updateUserLogin(int user_id) {
	String updateUserLogin = "update user_login_history set last_login = now(), total_login_attempt = 0 where user_id = ? ";
	Connection con=null;
	PreparedStatement ps=null;
	try {
		con=getConnection();
        ps = con.prepareStatement(updateUserLogin);
        ps.setLong(1, user_id);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public List<Boolean> getPagePermissions(int userId, int pageId) {
	String pagePermissions = "select * from user_permissions where user_id=? and webpage_id=?";
	List<Boolean> permissions = new ArrayList<>();
	Connection con=null;
	PreparedStatement ps=null;
	try {
		con=getConnection();
        ps = con.prepareStatement(pagePermissions);
        ps.setInt(1, userId);
        ps.setInt(2,pageId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            permissions.add(rs.getBoolean(3));
			permissions.add(rs.getBoolean(4));
			permissions.add(rs.getBoolean(5));
			permissions.add(rs.getBoolean(6));
            return permissions;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}




}
