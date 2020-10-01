package com.hsbc.model.dao;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;

public interface UserDao {
	public User authenticate(int userId, String password) throws AuthenticationException;
	public User store(User user);
	public Contact addContact(int userId, Contact contact);
	public User updateUser(int userId, User user);
	public Contact updateContact(int userId, int contactId, Contact contact);
	public List<Contact> fetchAllContacts(int userId);
	public void deleteUser(int userId);
	public void deleteContact(int userId, int contactId);
	public User getUser(int userId);
	public Contact getContact(int userId, int contactId);
}
