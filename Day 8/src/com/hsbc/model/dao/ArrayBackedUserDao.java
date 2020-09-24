package com.hsbc.model.dao;

import com.hsbc.model.beans.User;

public class ArrayBackedUserDao implements UserDao {

	// temporary database
	private static User[] userArray = new User[3];
	
	private static int index = 0;
	
	@Override
	public User store(User user) {
		userArray[index++] = user;
		return user;
	}
	@Override
	public User[] fetchUsers() {
		return userArray;
	}
	@Override
	public User fetchUserById(int userId) {
		User user = null;
		for(int i = 0; i < index; i++) {
			if(userArray[i].getUserId() == userId) { 
				user = userArray[i];
				return user;
			}
		}
		return null;
	}
	// Implement this method
	@Override
	public User updateUser(int userId, User user) {
		for(int i = 0; i < index; i++) {
			if(userArray[i].getUserId() == userId) {
				userArray[i] = user;
				break;
			}
		}
		return user;
	}

}
