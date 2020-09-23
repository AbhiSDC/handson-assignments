package com.hsbc.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.beans.User;

public class FileBackedDao implements UserDao {

	private static List<User> userList = new ArrayList<User>();
	
	public FileBackedDao() {
		super();
		try {
			deserialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User store(User user) {
		userList.add(user);
		serialize();
		return user;
	}
	
	private static void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("fileDb.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			System.out.println("All Users have been Serialized.");
			fos.flush();
			fos.close();
			oos.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	@SuppressWarnings("unchecked")
	private List<User> deserialize() throws IOException{
		try {
			FileInputStream fis = new FileInputStream("fileDb.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			userList = (List<User>) ois.readObject();
			ois.close();
			fis.close();
		}
		catch(IOException e) {
			File file = new File("fileD.ser");
			if(file.createNewFile()) {
				 System.out.println("File Not Found! New File has been created.");
			}
		}
		catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public User[] fetchUsers() {
		try {
			userList = deserialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
