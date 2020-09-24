package com.hsbc.model.dao;


import com.hsbc.model.beans.User;

/*
 * This interface must have more than 4 methods
 * 
 */
public interface UserDao {
	public User store(User user);
	public User[] fetchUsers();
	// returns null if userId not found else returns user
	public User fetchUserById(int userId); 
	
	// pass updated user and reflect to the database/array/collection & return the same user
	public User updateUser(int userId, User user);
}
