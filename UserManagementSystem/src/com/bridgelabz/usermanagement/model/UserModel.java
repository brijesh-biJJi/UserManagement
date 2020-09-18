package com.bridgelabz.usermanagement.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class UserModel {
	private String user_id;   
	private String email;         
	private String first_name;     
	private String middle_name;    
	private String last_name;   
	private Date dob;
    private int phone;
    private String address;			
    private boolean verified;      
    private String username;		
    private String password;      
    private String cpassword;		
    private LocalDateTime creator_at;
	
    public UserModel() {
	}
	
	
	
	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public UserModel(String user_id, String email, String first_name, String middle_name, String last_name, Date dob,
			int phone, String address, boolean verified, String username, String password, String cpassword,
			LocalDateTime creator_at) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.verified = verified;
		this.username = username;
		this.password = password;
		this.cpassword = cpassword;
		this.creator_at = creator_at;
	}



	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public LocalDateTime getCreator_at() {
		return creator_at;
	}
	public void setCreator_at(LocalDateTime creator_at) {
		this.creator_at = creator_at;
	}
	
	
}
