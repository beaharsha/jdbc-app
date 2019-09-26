package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCAppExecuteMethod {
	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter query \n");
		String QUERY = sc.nextLine();
		System.out.println("query : " + QUERY);
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root",
				"root"); Statement statement = connection.createStatement();) {

			boolean flag = statement.execute(QUERY);
			if (flag) {
				ResultSet results = statement.getResultSet();
				while (results.next()) {
					System.out.println(" column 1 " + results.getObject(1));
				}
			} else {
				System.out.println("no. of rows affected " + statement.getUpdateCount());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
