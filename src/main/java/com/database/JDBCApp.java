package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApp {
	public static void main(String[] args) throws SQLException {

		String QUERY = "select * from persons";
		Connection connection = null;
		Statement statement = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(QUERY);
			
			while(results.next()) {
				System.out.println("ID : " +results.getInt(1)
				+" Last Name : "+results.getString(2)
				+ " First Name : "+ results.getString(3)
				+ " Address : "+ results.getString(4)
				+ " City : "+results.getString(5)
						);
			}
			
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

}