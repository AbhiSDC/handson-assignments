package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.derby.jdbc.ClientDriver;

import com.hsbc.model.beans.User;
import com.hsbc.model.utility.DBUtility;

public class JDBCBackedDao implements UserDao {

	@Override
	public User store(User user) {
		try {
			Scanner scanner = new Scanner(System.in);
			Class.forName(ClientDriver.class.getName());
			Connection connection = DBUtility.getConnection();
			PreparedStatement createTable = connection.prepareStatement("insert into user_table values(next value for userid_seq, ?, ?, ?)");
			createTable.setString(1, user.getName());
			createTable.setString(2, user.getPassword());
			createTable.setLong(3, user.getPhone());
			int i = createTable.executeUpdate();
			System.out.println(i + " Record inserted");
			createTable.close();
			connection.close();
			scanner.close();
			} 
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		return user;
	}

	@Override
	public User[] fetchUsers() {
		// TODO Auto-generated method stub
		return null;
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
