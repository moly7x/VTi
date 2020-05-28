//
package com.vti.JavaFinal.backend.datalayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.JavaFinal.utils.DatabaseUtils;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class EmployeeDAO implements IEmployeeDAO {
	@Override
	public boolean register(String firstname, String lastname, String phone, String email, int projectName,
			String proSkill, String pass) throws SQLException, IOException {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			connect = DatabaseUtils.connect();
			query = connect.prepareStatement(
					"INSERT INTO Employee (firstname, lastname, phone, email, projectName, proSkill, pass)VALUES (?, ?, ?, ?, ?, ?, ?);");
			query.setString(1, firstname);
			query.setString(2, lastname);
			query.setString(3, phone);
			query.setString(4, email);
			query.setInt(5, projectName);
			query.setString(6, proSkill);
			query.setString(7, pass);
			query.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			DatabaseUtils.closeAll(connect, query, result);
		}

	}

	/*
	 * @see com.vti.JavaFinal.backend.datalayer.IEmployeeDAO#login(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, int, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean login(String email, String pass) throws SQLException, IOException {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			connect = DatabaseUtils.connect();
			query = connect.prepareStatement("Select email, pass from employee where email = ? and pass = ?");
			query.setString(1, email);
			query.setString(2, pass);
			result = query.executeQuery();
			result.last();
			if (result.getRow() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			DatabaseUtils.closeAll(connect, query, result);
		}
	}
}
