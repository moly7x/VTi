//
package com.vti.Assignemnt_9.utils;

import java.io.FileReader;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.vti.Assignemnt_9.frontend.Errors;

/**
 * This class is Database Connection.
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class DatabaseUtils {
	/**
	 * 
	 * This method is connecting to database.
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 * @throws Errors
	 */
	public static Connection connect() throws Errors {
		try {
			// Read from jdbc.properties
			FileReader reader = new FileReader("src/main/resources/jdbc.properties");
			Properties properties = new Properties();
			properties.load(reader);
			reader.close();
			// Get information database
			String username = properties.getProperty("username");
			String pass = properties.getProperty("password");
			String dbUrl = properties.getProperty("connectionString");

			// Connect database
			Connection sqlconnection = DriverManager.getConnection(dbUrl, username, pass);
			return sqlconnection;
		} catch (SQLException e) {
			throw new Errors(1000);
		} catch (IOException e) {
			throw new Errors(1001);
		}

	}

	public static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
}
