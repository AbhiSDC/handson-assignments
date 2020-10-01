package com.hsbc.model.business;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.DuplicateContactException;
import com.hsbc.exception.DuplicateUserException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;

public interface UserService {
	public User login(int userId, String password) throws AuthenticationException;
	public User createUser(User user) throws DuplicateUserException;
	public Contact addContact(int userId, String name, long contact) throws DuplicateContactException;
	public List<Contact> fetchAllContacts(int userId);
	public User updatePhone(int userId, long phone);
	public User updatePassword(int userId, String password);
	public Contact updateContactName(int userId, int contactId, String name);
	public Contact updateContactNumber(int userId, int contactId, long contact);
	public void deleteContact(int userId, int contactId);
	public void deleteUser(int userId);
	public User getUser(int userId);
	public Contact getContact(int userId, int contactId);
}

