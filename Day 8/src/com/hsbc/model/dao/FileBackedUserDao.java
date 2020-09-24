package com.hsbc.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.beans.User;

public class FileBackedUserDao implements UserDao {

	private List<User> usersList = deserialize();
	
	private void serialize(List<User> usersList) {
		try {
			FileOutputStream fos = new FileOutputStream("AllUsers.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(usersList);
			fos.flush();
			oos.close();
			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// it has to read a file & return all the users present in the list
	@SuppressWarnings("unchecked")
	private List<User> deserialize() {
		try {
			FileInputStream fis = new FileInputStream("AllUsers.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// this generates EOFException only if file doesn't have arrayList
			usersList = (List<User>)ois.readObject();
			ois.close();
			fis.close();
		} catch(FileNotFoundException | EOFException e) {
			usersList = new ArrayList<User>();
			serialize(usersList);
		}
		catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	@Override
	public User store(User user) {
		this.usersList = deserialize();
		int generatedId = usersList.size()+1;
		user.setUserId(generatedId);
		this.usersList.add(user);
		serialize(this.usersList);
		return user;
	}

	@Override
	public User[] fetchUsers() {
		this.usersList = deserialize();
		User[] userArray = new User[usersList.size()];
		userArray = usersList.toArray(userArray);
		return userArray;
	}

	@Override
	public User fetchUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
