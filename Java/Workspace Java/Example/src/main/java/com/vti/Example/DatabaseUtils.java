//
package com.vti.Example;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
	 * @throws SQLException
	 * @throws IOException
	 */
	public static Connection connect() throws SQLException, IOException {
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
			// Can't connect to database
			throw new SQLException(e);
		} catch (IOException e) {
			// Can't not find properties
			throw new IOException(e);
		}

	}
}
