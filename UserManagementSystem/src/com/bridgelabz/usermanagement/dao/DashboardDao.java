package com.bridgelabz.usermanagement.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bridgelabz.usermanagement.model.ConnectionModel;
import com.bridgelabz.usermanagement.model.UserModel;

public class DashboardDao {
	
	ConnectionModel conModel=new ConnectionModel();
	UserModel userModel=new UserModel();
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
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


	public String getUserLastLogin(int userId) {
		String getUserLastLogin = "select last_login from user_login_history where user_id = ?";
		Connection con=null;
		PreparedStatement ps=null; 
		 try {
			 con=getConnection(); 
	            ps = con.prepareStatement(getUserLastLogin);
	            ps.setInt(1,userId);
	            ResultSet rs = ps.executeQuery();
	            
	            DateFormat df = new SimpleDateFormat("MMM dd yyyy hh:mm a");
	            if(rs.next())
	                return df.format(rs.getTimestamp(1));
	            else {
	                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
	                return dtf.format(LocalDateTime.now());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	}


	public Long getTotalUsersByStatus(String status) {
		String getTotalUsersByStatus = "select count(*) from user where status like ?";
		Connection con=null;
		PreparedStatement ps=null; 
		 try {
			 con=getConnection(); 
	            ps = con.prepareStatement(getTotalUsersByStatus);
	            ps.setString(1,status);
	            ResultSet resultSet = ps.executeQuery();
	            if (resultSet.next()) {
	                return resultSet.getLong(1);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	
	public List<UserModel> getLatestRegistrations(int totalUser) {
		String getLatestRegistration = "select * from" +
	            " user order by user_id desc limit 0,?";
		 List<UserModel> usersList = new ArrayList<>();
		 Connection con=null;
			PreparedStatement ps=null; 
			 try {
				 con=getConnection(); 
	            DateFormat df = new SimpleDateFormat("MMM dd yyyy hh:mm a");
	            ps = con.prepareStatement(getLatestRegistration);
	            ps.setInt(1,totalUser);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                UserModel u = new UserModel();
	                u.setUser_id(rs.getInt(1)); 
	                u.setFirst_name(rs.getString(3));
	                u.setLast_name(rs.getString(5)); 
	                u.setCreator_at(df.format(rs.getDate(10)));
	                usersList.add(u);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return usersList;
	}
}
