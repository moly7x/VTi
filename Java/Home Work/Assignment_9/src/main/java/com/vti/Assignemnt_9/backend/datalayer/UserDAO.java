//
package com.vti.Assignemnt_9.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.Assignemnt_9.Entity.User;
import com.vti.Assignemnt_9.frontend.Errors;
import com.vti.Assignemnt_9.utils.DatabaseUtils;

/**
 * This class user database.
 * 
 * @author: Tân
 * @create_date: 29/03/2020
 */
public class UserDAO {

	/**
	 * 
	 * This method is insert user information.
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param user
	 * @throws Errors
	 */
	public static void registerUser(User user) throws Errors {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"INSERT INTO `User` (ACCOUNT, FIRSTNAME, LASTNAME, EMAIL)VALUES (?, ?, ?, ?);");

			query.setString(1, user.getAccount());
			query.setString(2, user.getFirst_name());
			query.setString(3, user.getLast_name());
			query.setString(4, user.getEmail());

			// Execute query and close previous query
			query.executeUpdate();
			query.close();
		} catch (SQLException e) {
			throw new Errors(1000);
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}

	/**
	 * 
	 * This method check Exist email .
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param email
	 * @return id of email
	 * @throws Errors
	 */
	public static int isExistEmail(String email) throws Errors {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			// get user Id have just been created
			query = connect.prepareStatement("SELECT USERID FROM `USER` WHERE EMAIL = ?;");
			query.setString(1, email);
			result = query.executeQuery();

			// get user id of that email if it exist
			if (result.next()) {
				return result.getInt("USERID");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			throw new Errors(1000);
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}
	
	/**
	 * 
	 * This method check Exist account .
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param email
	 * @return id of account
	 * @throws Errors
	 */
	public static int isExistAccount(String account) throws Errors {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			// get user Id have just been created
			query = connect.prepareStatement("SELECT USERID FROM `USER` WHERE `ACCOUNT` = ?;");
			query.setString(1, account);
			result = query.executeQuery();
			// get user id of that email if it exist
			if (result.next()) {
				return result.getInt("USERID");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			throw new Errors(1000);
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}
	
	/**
	 * 
	 * This method is update user information.
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param user
	 * @throws Errors
	 */
	public static void updateUser(User user) throws Errors {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement("UPDATE User SET Account = ?, FIRSTNAME = ?, LASTNAME = ?, EMAIL = ? WHERE (ACCOUNT = ? OR EMAIL = ?)");
			query.setString(1, user.getAccount());
			query.setString(2, user.getFirst_name());
			query.setString(3, user.getLast_name());
			query.setString(4, user.getEmail());
			query.setString(5, user.getAccount());
			query.setString(6, user.getEmail());

			// Execute query and close previous query
			query.executeUpdate();
			query.close();
		} catch (SQLException e) {
			throw new Errors(1000);
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}
}
