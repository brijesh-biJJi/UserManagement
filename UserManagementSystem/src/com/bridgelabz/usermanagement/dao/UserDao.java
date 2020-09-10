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
	
	public int addUser(UserModel u) {
		
		String addQuery="insert into user(email,first_name,last_name,phone,address,verified,username,password,cpassword,dob) VALUES(?,?,?,?,?,?,?,?,?,?)";
		  int status=0;  
	        try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement(addQuery);
	            ps.setString(1,u.getEmail());
	            ps.setString(2, u.getFirst_name());
	            ps.setString(3, u.getLast_name());
	            ps.setInt(4,u.getPhone());
	            ps.setString(5,u.getAddress());
	            ps.setBoolean(6, u.isVerified());
	            ps.setString(7,u.getUsername());
	            ps.setString(8,u.getPassword());
	            ps.setString(9,u.getCpassword());
	            ps.setDate(10, u.getDob());
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	}
	
	public int updateUser(UserModel u) {
		
		String updateQuery="update user set email=?, first_name=?, last_name=?, phone=?,address=?,verified=?, username=?,password=?,cpassword=?,dob=? where user_id=?";
		  int status=0;  
	        try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement(updateQuery);
	            ps.setString(1,u.getEmail());
	            ps.setString(2, u.getFirst_name());
	            ps.setString(3, u.getLast_name());
	            ps.setInt(4,u.getPhone());
	            ps.setString(5,u.getAddress());
	            ps.setBoolean(6, u.isVerified());
	            ps.setString(7,u.getUsername());
	            ps.setString(8,u.getPassword());
	            ps.setString(9,u.getCpassword());
	            ps.setDate(10, u.getDob());
	            ps.setString(11,u.getUser_id());
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	}
	
	 public int deleteUser(String id){  
	        int status=0;  
	        try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from user where id=?");  
	            ps.setString(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	
	 public List<UserModel> getAllUser(){  
	        List<UserModel> list=new ArrayList<UserModel>();  
	          
	        try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                UserModel u = new UserModel();  
	                u.setUser_id(rs.getString(1)); 
	                u.setEmail(rs.getString(2));
	                u.setFirst_name(rs.getString(3));  
	                u.setLast_name(rs.getString(4));  
	                u.setPhone(rs.getInt(5));
	                u.setAddress(rs.getString(6));
	                u.setVerified(rs.getBoolean(7));
	                u.setUsername(rs.getString(8));
	                u.setPassword(rs.getString(9));
	                u.setCpassword(rs.getString(10));
	                u.setDob(rs.getDate(11));
	                list.add(u);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	 
	 public String passwordRecovery(String email) {
		 
		 	String notification = null;
			Connection con=getConnection();
			userModel.setEmail(email);
			String qry="select * from user where email=?";
			
			try {
				pstmt=con.prepareStatement(qry);
				pstmt.setString(1, userModel.getEmail());
				
				rs=pstmt.executeQuery();
				System.out.println("in pr-------");
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
					
					notification="success";
					return notification;

				}
				else {
					notification="fail";
				}
						
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return notification;
	 }
	

}
