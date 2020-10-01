package com.hsbc.model.business;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

public class UserServiceImpl implements UserService {

	private UserDao dao;
	public UserServiceImpl() {
		// this is the way you get different instance
		dao = (UserDao)UserFactory.getInstance(Type.DAO);
	}
	@Override
	public User storeUser(User user) {
		// no business validation
		User createdUser =  dao.store(user);
		return createdUser;
	}
	@Override
	public User[] getAllUsers() {
		// no business validations
		return dao.fetchUsers();
	}
	@Override
	public User fetchUserById(int userId) throws UserNotFoundException {
		// no business validation done
		User user = dao.fetchUserById(userId);
		if(user == null) {
			throw new UserNotFoundException("Sorry user with an id "+userId+" not found");
		}
		return user;
	}
	// Implement updatePhoneNo
	@Override
	public User updatePhoneNo(int userId, long phone) throws UserNotFoundException {
		User user = this.fetchUserById(userId);
		user.setPhone(phone);
		return dao.updateUser(userId, user);
		
	}
	// Implement updatePhoneNo
	@Override
	public User updatePassword(int userId, String newPassword) throws UserNotFoundException {
		User user = this.fetchUserById(userId);
		user.setPassword(newPassword);
		return dao.updateUser(userId, user);
	}
}
