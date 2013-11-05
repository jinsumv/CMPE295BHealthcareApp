package com.secondopinion.common.model;

public class User {
	
	int userId;
	String userName;
	String password;
	boolean enabled;
	
	public User(int userId, String userName, String password, boolean enabled) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
