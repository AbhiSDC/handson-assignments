package com.hsbc.concepts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.hsbc.model.utility.DBUtility;

public class TransactionDemo {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DBUtility.getConnection();
			connection.setAutoCommit(false);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id");
			int id = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter state");
			String state = sc.next();
			System.out.println("Enter city");
			String city = sc.next();
			PreparedStatement empStatement = connection.prepareStatement("insert into emp values(?, ?)");
			empStatement.setInt(1, id);
			empStatement.setString(2, name);
			empStatement.executeUpdate();
			PreparedStatement addrStatement = connection.prepareStatement("insert into address values(?, ? ,?)");
			addrStatement.setString(1, state);
			addrStatement.setString(2, city);
			addrStatement.setInt(3, id);
			addrStatement.executeUpdate();
			connection.commit();
			System.out.println("Everything stored properly");
			empStatement.close();
			addrStatement.close();
			connection.close();
			sc.close();
		}
		catch(SQLException | ClassNotFoundException c) {
			c.printStackTrace();
			try {
				connection.rollback();
			}
			catch(SQLException s) {
				s.printStackTrace();
			}
		}
	}
}
