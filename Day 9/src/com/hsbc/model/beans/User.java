package com.hsbc.model.beans;

public class User {
	private int userId;
	private String name;
	private long phone;
	private String password;
	
	public User(int userId, String name, long phone, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + ", password=" + password + "]";
	}
	
}
