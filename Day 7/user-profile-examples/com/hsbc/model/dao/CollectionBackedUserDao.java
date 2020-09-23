package com.hsbc.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.beans.User;

public class CollectionBackedUserDao implements UserDao {
	
	// create a ArrayList with List reference
	List<User> userList = new ArrayList<User>();
	
	@Override
	public User store(User user) {
		userList.add(user);
		return user;
	}

	@Override
	public User[] fetchUsers() {
		return (User[]) userList.toArray(new User[userList.size()]);
	}

	@Override
	public User fetchUserById(int userId) {
		for(User user : userList) {
			if(user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User updateUser(int userId, User user) {
		int ind = 0;
		for(User us : userList) {
			if(us.getUserId() == userId) {
				ind = userList.indexOf(us);
				break;
			}
		}
		userList.set(ind, user);
		return user;
	}

}
