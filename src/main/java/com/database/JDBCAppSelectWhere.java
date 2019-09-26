package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCAppSelectWhere {
	public static void main(String[] args) throws SQLException {

		String QUERY1 = "select personid, firstname from persons where address = 'koti'";
		String QUERY2 = "select lastname, firstname from persons where address = 'koti'";

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet results1 = statement.executeQuery(QUERY1);

			while (results1.next()) {
				System.out.println("ID : " + results1.getInt(1) + " \nFirst Name : " + results1.getString(2));
			}
			System.out.println("Second Query");
			ResultSet results2 = statement.executeQuery(QUERY2);
			while (results2.next()) {
				System.out.println("Last name : " + results2.getString(1) + " \nFirst Name : " + results2.getString(2));
			}
		} catch (Exception e) {

		}
	}
}
