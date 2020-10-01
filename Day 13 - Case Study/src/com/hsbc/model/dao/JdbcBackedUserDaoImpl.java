package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.DBUtility;

public class JdbcBackedUserDaoImpl implements UserDao {
	
	List<User> usersList = new ArrayList<User>();
	List<Contact> contactList = new ArrayList<Contact>();
	
	@Override
	public User authenticate(int userId, String password) throws AuthenticationException {
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_profile where user_id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone_no"));
				user.setDob(resultSet.getString("dob"));
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
			PreparedStatement preparedStatement;
			Connection connection = DBUtility.getConnection();
			String checkQuery = "select * from user_profile where name = ? and password = ?";
			preparedStatement = connection.prepareStatement(checkQuery);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				user = null;
			}
			
			String loginQuery = "insert into user_profile values (next value for profile_seq,?,?,?,?)";
			preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setLong(3, user.getPhone());
			preparedStatement.setString(4, user.getDob());
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
	public Contact addContact(int userId, Contact contact) {
		try {
			Connection connection = DBUtility.getConnection();
			String checkQuery = "select * from user_contact where id_ref = ? and name = ? and phone_no = ?";
			PreparedStatement pStatement = connection.prepareStatement(checkQuery);
			pStatement.setInt(1, userId);
			pStatement.setString(2, contact.getContactName());
			pStatement.setLong(3, contact.getContactNo());
			ResultSet resultSet = pStatement.executeQuery();
			if(resultSet.next()) {
				return null;
			}
			
			String loginQuery = "insert into user_contact values (next value for contact_seq,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setString(1, contact.getContactName());
			preparedStatement.setLong(2, contact.getContactNo());
			preparedStatement.setInt(3, contact.getUserId());
			preparedStatement.executeQuery();
			
			String finalQuery = "select contact_id from user_contact where id_ref = ? and name = ? and phone_no = ?";
			preparedStatement = connection.prepareStatement(finalQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, contact.getContactName());
			preparedStatement.setLong(3, contact.getContactNo());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				contact.setContactId(resultSet.getInt("contact_id"));
			}
			
			resultSet.close();
			pStatement.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contact;
	}
	
	@Override
	public List<Contact> fetchAllContacts(int userId) {
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_contact whre id_ref = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Contact con = new Contact();
				con.setContactId(resultSet.getInt("contact_id"));
				con.setContactName(resultSet.getString("name"));
				con.setContactNo(resultSet.getLong("phone"));
				con.setUserId(resultSet.getInt("id_ref"));
				contactList.add(con);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contactList;
	}
	
	@Override
	public User updateUser(int userId, User user) {	
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "update user_profile set password = ?, phone_no = ? where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setLong(2, user.getPhone());
			preparedStatement.setInt(3, userId);
			preparedStatement.executeUpdate();
			connection.commit();
			System.out.println("User Details have been Updated Successfully.");
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public Contact updateContact(int userId, int contactId, Contact contact) {
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "update user_contact set name = ?, phone_no = ? where contact_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setString(1, contact.getContactName());
			preparedStatement.setLong(2, contact.getContactNo());
			preparedStatement.setInt(3, contactId);
			preparedStatement.executeUpdate();
			connection.commit();
			System.out.println("Contact Details have been Updated Successfully.");
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contact;
	}

	@Override
	public void deleteUser(int userId) {
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "delete from user_profile where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteContact(int userId, int contactId) {
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "delete from user_contact where contact_id = ? and user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, contactId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User getUser(int userId) {
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_profile where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone_no"));
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
	public Contact getContact(int userId, int contactId) {
		Contact con = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_contact where id_ref = ? and contact_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, contactId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				con = new Contact();
				con.setContactId(resultSet.getInt("contact_id"));
				con.setContactName(resultSet.getString("name"));
				con.setContactNo(resultSet.getLong("phone_no"));
				con.setUserId(resultSet.getInt("id_ref"));
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
