package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCAppUpdate {
	public static void main(String[] args) throws SQLException {

		String QUERY = "insert into persons values (104, 'khan', 'zahir','delhi','delhi')";

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root",
				"root"); Statement statement = connection.createStatement();) {

			int results = statement.executeUpdate(QUERY);

			System.out.println("number of rows effected for insert "+results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
