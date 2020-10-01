package com.hsbc.concepts;

import java.sql.SQLException;
import java.util.Scanner;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			//Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mydb", "abhishek", "abhi@98");
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:derby://localhost:1527/mydb");
			rowSet.setUsername("abhishek");
			rowSet.setPassword("abhi@98");
			//rowSet.setCommand("select * from address");
			rowSet.setCommand("select * from emp join address on id = id_ref where id = ?");
			rowSet.setInt(1, 1);
			rowSet.execute();
			while(rowSet.next()) {
				System.out.println("Id: " + rowSet.getInt("id"));
				System.out.println("Name: " + rowSet.getString("name"));
				System.out.println("State: " + rowSet.getString("state"));
				System.out.println("City: " + rowSet.getString("city"));
			}
			
			rowSet.close();
			scanner.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
