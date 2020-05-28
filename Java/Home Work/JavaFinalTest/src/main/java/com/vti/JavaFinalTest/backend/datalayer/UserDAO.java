//
package com.vti.JavaFinalTest.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.JavaFinalTest.entity.User;
import com.vti.JavaFinalTest.frontend.Errors;
import com.vti.JavaFinalTest.utils.DatabaseUtils;

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
	 * @return id of register
	 * @throws Errors
	 */
	static int registerUser(User user, int key) throws Errors {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"INSERT INTO `User` (FIRSTNAME, LASTNAME, EMAIL, PHONE, `PASSWORD`, `ROLE`)VALUES (?, ?, ?, ?, ?, ?);");

			query.setString(1, user.getFirstname());
			query.setString(2, user.getLastname());
			query.setString(3, user.getEmail());
			query.setString(4, user.getPhone());
			query.setString(5, user.getPassword());
			// Set role manager or employee
			switch (key) {
			case 0:
				query.setString(6, "MANAGER");
				break;
			case 1:
				query.setString(6, "EMPLOYEE");
				break;
			}

			// Execute query and close previous query
			query.executeUpdate();
			query.close();

			// get user Id have just been created
			query = connect.prepareStatement("SELECT USERID FROM `USER` WHERE EMAIL = ?;");
			query.setString(1, user.getEmail());
			result = query.executeQuery();

			// move to first row
			result.first();
			return result.getInt("USERID");
		} catch (SQLException e) {
			throw new Errors(1000);
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}

	/**
	 * 
	 * This method check duplication email .
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param email
	 * @return true if already have an email like input
	 * @throws Errors
	 */
	public static boolean isDubEmail(String email) throws Errors {
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

			// check have first row or not
			result.last();
			if (result.getRow() == 0) {
				return true;
			} else {
				return false;
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
	 * This method check duplication phone number .
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param email
	 * @return true if already have an phone number like input
	 * @throws Errors
	 */
	public static boolean isDubPhone(String phone) throws Errors {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			// get user Id have just been created
			query = connect.prepareStatement("SELECT USERID FROM `USER` WHERE PHONE = ?;");
			query.setString(1, phone);
			result = query.executeQuery();

			// check have first row or not
			result.last();
			if (result.getRow() == 0) {
				return true;
			} else {
				return false;
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
	 * This method checking login . 
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @param email
	 * @param password
	 * @return
	 * @throws Errors
	 */
	public static String login(String email, String password) throws Errors {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			// query account
			query = connect.prepareStatement("SELECT ROLE FROM `USER` WHERE EMAIL = ? AND PASSWORD = ?;");
			query.setString(1, email);
			query.setString(2, password);
			result = query.executeQuery();

			// check have first row or not
			result.last();
			if (result.getRow() == 0) {
				throw new Errors(1010);
			} else {
				result.first();
				return result.getString("ROLE");
			}
		} catch (SQLException e) {
			throw new Errors(1000);
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}
}
