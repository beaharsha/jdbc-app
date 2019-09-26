package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {
	public static void main(String[] args) throws SQLException {

		String QUERY = "select * from persons where personid = 101";
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			statement = connection.prepareStatement(QUERY);
			
			ResultSet results = statement.executeQuery();
			
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
