//
package studentManagement.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
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
	 * @throws Errors
	 */
	public static Connection connect() {
		try {
			// Read from jdbc.properties
			FileReader reader = new FileReader("E:/Passport IT/Java/Workspace/Students_Management/resources/jdbc.properties");
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
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;

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
