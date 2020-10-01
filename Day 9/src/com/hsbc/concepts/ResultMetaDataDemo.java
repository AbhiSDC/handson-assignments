package com.hsbc.concepts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.derby.jdbc.ClientDriver;
import com.hsbc.model.utility.DBUtility;

public class ResultMetaDataDemo {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			Class.forName(ClientDriver.class.getName());
			//Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mydb", "abhishek", "abhi@98");
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table");
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultMeta = resultSet.getMetaData();
			System.out.println("Columns Count: " + resultMeta.getColumnCount());
			System.out.println("Column No. 2: " + resultMeta.getColumnName(2));
			System.out.println("Type for Column No. 1: " + resultMeta.getColumnTypeName(1));
			
			resultSet.close();
			preparedStatement.close();
			connection.close();
			scanner.close();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
}

