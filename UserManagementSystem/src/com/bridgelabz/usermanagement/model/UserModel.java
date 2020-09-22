package com.bridgelabz.usermanagement.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class UserModel {
	private int user_id;   
	private String email;         
	private String first_name;     
	private String middle_name;    
	private String last_name;   
	private String dob;
	private String gender;
	private long phone;
    private String address;	      
    private String username;		
    private String password;      
    private String cpassword;
    private String country;
    private String user_role;
    private String status;
    private String image;
    private String creator_at;
	
    public UserModel() {
	}

	public UserModel(int user_id, String email, String first_name, String middle_name, String last_name, String dob,
			String gender, long phone, String address, String username, String password, String cpassword,
			String country, String user_role, String status, String image, String creator_at) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
		this.cpassword = cpassword;
		this.country = country;
		this.user_role = user_role;
		this.status = status;
		this.image = image;
		this.creator_at = creator_at;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreator_at() {
		return creator_at;
	}

	public void setCreator_at(String creator_at) {
		this.creator_at = creator_at;
	}

	@Override
	public String toString() {
		return "UserModel [user_id=" + user_id + ", email=" + email + ", first_name=" + first_name + ", middle_name="
				+ middle_name + ", last_name=" + last_name + ", dob=" + dob + ", gender=" + gender + ", phone=" + phone
				+ ", address=" + address + ", username=" + username + ", password=" + password + ", cpassword="
				+ cpassword + ", country=" + country + ", user_role=" + user_role + ", status=" + status + ", image="
				+ image + ", creator_at=" + creator_at + "]";
	}

	

}
