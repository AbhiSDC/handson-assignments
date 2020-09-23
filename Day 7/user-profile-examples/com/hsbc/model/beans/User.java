package com.hsbc.model.beans;

public class User {
	private int userId;
	private String name;
	private String password;
	private long phone;
	// later we will add address
	
	// this is a dummy counter used because we don't have database
	private static int userCounter = 1;
	
	public int getUserId() {
		return userId;
	}
	public User() {
		super();
		this.userId = userCounter++;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", phone=" + phone + "]";
	}
	
}
