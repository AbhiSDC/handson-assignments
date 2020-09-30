package com.hsbc.model.business;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
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
	public User createUser(User user) {
		return userDao.store(user);
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
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Override
	public List<User> fetchAllUsers() {
		return userDao.fetchAllUsers();
	}

}
