package com.hsbc.model.business;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.DuplicateContactException;
import com.hsbc.exception.DuplicateUserException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.LayerType;
import com.hsbc.model.util.UserFactory;

public class UserServiceImpl implements UserService {

	private UserDao userDao = null;
	
	public UserServiceImpl() {
		userDao = (UserDao)UserFactory.getInstance(LayerType.DAO);
	}
	
	@Override
	public User login(int userId, String password) throws AuthenticationException {
		User user = userDao.authenticate(userId, password);
		if(user == null) {
			throw new AuthenticationException("Sorry something went wrong");
		}
		return user;
	}

	@Override
	public User createUser(User user) throws DuplicateUserException {
		User newUser = userDao.store(user);
		if(user == null) {
			throw new DuplicateUserException("User already registered.");
		}
		return newUser;
	}
	
	@Override
	public Contact addContact(int userId, String name, long contact) throws DuplicateContactException {
		Contact newContact = new Contact(name, contact, userId);
		Contact con = userDao.addContact(userId, newContact);
		if(con == null) {
			throw new DuplicateContactException();
		}
		return con;
	}
	
	@Override
	public List<Contact> fetchAllContacts(int userId) {
		return userDao.fetchAllContacts(userId);
	}

	@Override
	public User updatePhone(int userId, long phone) {
		User user = this.getUser(userId);
		user.setPhone(phone);
		return userDao.updateUser(userId, user);
	}

	@Override
	public User updatePassword(int userId, String password) {
		User user = this.getUser(userId);
		user.setPassword(password);
		return userDao.updateUser(userId, user);
	}

	@Override
	public Contact updateContactName(int userId, int contactId, String name) {
		Contact updateCon = this.getContact(userId, contactId);
		updateCon.setContactName(name);
		Contact ansCon = userDao.updateContact(userId, contactId, updateCon);
		return ansCon;
	}
	
	@Override
	public Contact updateContactNumber(int userId, int contactId, long contact)  {
		Contact updateCon = this.getContact(userId, contactId);
		updateCon.setContactNo(contact);
		Contact ansCon = userDao.updateContact(userId, contactId, updateCon);

		return ansCon;
	}
	
	@Override
	public void deleteContact(int userId, int contactId) {
		userDao.deleteContact(userId, contactId);
	}
	
	@Override
	public void deleteUser(int userId) { 
		userDao.deleteUser(userId);
	}
	
	@Override
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Override
	public Contact getContact(int userId, int contactId) {
		return userDao.getContact(userId, contactId);
	}

}
