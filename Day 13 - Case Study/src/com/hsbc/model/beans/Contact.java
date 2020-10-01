package com.hsbc.model.beans;

public class Contact extends User {
	private int contactId;
	private String contactName;
	private long contactNo;
	private int userId;
	
	public Contact() {}

	public Contact(String name, long phoneNo, int userId) {
		this.contactName = name;
		this.contactNo = phoneNo;
		this.userId = userId;
	}

	public int getContactId() {
		return contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNo=" + contactNo
				+ ", userId=" + userId + "]";
	}

}
