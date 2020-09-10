package com.bridgelabz.usermanagement.model;

public class ConnectionModel {
	private String dbuser;
	private String dbpass;
	private String dburl;
	
	public String getDburl() {
		return dburl;
	}

	public void setDburl(String dburl) {
		this.dburl = dburl;
	}

	public String getDbuser() {
		return dbuser;
	}
	
	public void setDbuser(String dbuser) {
		this.dbuser = dbuser;
	}
	
	public String getDbpass() {
		return dbpass;
	}
	
	public void setDbpass(String dbpass) {
		this.dbpass = dbpass;
	}

}
