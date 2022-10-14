package com.demo.beans;

public class User {
	
	
	private String userEmail;
	private String password;
	private String role;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", password=" + password + ", role=" + role + "]";
	}
	

}
