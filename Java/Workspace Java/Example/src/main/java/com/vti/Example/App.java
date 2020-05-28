package com.vti.Example;

import java.io.IOException;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException, SQLException {

		Connection sqlconnection = DatabaseUtils.connect();

		System.out.println("Connect success!!");

		Statement queries = sqlconnection.createStatement();

		ResultSet result = queries.executeQuery("SHOW VARIABLES LIKE  'char%';");
		
		result.last();
		System.out.println(result.getRow());
		result.beforeFirst();
		while (result.next()) {
			System.out.println(result.getRow());
			System.out.println(result.getString(1) + "   " + result.getString(2));
		}

		System.out.println();
		result = queries.executeQuery("SELECT * FROM NHACC");
		while (result.next()) {
			System.out.println(result.getString(1) + "   " + result.getString(2) + "   " + result.getInt(3) + "   "
					+ result.getString(4));
		}

		result.close();
		queries.close();
		sqlconnection.close();
	}
}
