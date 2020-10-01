package com.hsbc.model.beans;

public class User {
	private int userId;
	private String name;
	private String password;
	private long phone;
	private String dob;
	
	public User() {}
	
	public User(int userId, String name, String password, long phone, String dob) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", phone=" + phone + ", dob="
				+ dob + "]";
	}
	
}
