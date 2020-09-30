package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.DBUtility;

public class JdbcBackedUserDaoImpl implements UserDao {
	
	List<User> usersList = new ArrayList<User>();
	
	@Override
	public User authenticate(int userId, String password) throws AuthenticationException {
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_table where user_id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				return user;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			if(user == null) {
				throw new AuthenticationException("Sorry Username or Password is Incorrect");
			} 
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User store(User user) {
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "insert into user_table values (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getPhone());
			preparedStatement.executeUpdate();
			connection.commit();
			System.out.println("Everything stored properly");
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUser(int userId) {
		User user = new User();
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_table where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<User> fetchAllUsers() {
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_table";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				usersList.add(user);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	@Override
	public User updateUser(int userId, User user) {	
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "update user_table set password = ?, phone = ? where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setLong(2, user.getPhone());
			preparedStatement.setInt(3, userId);
			preparedStatement.executeUpdate();
			connection.commit();
			System.out.println("Details have been Updated Successfully.");
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

}
