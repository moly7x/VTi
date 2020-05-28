//
package com.vti.JavaFinalTest.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.JavaFinalTest.entity.Manager;
import com.vti.JavaFinalTest.frontend.Errors;
import com.vti.JavaFinalTest.utils.DatabaseUtils;

/**
 * This class Manager database . 
 * 
 * @author: Tân
 * @create_date: 29/03/2020
 */
public class ManagerDAO {
	/**
	 * 
	 * This method register Manager . 
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param manager
	 * @throws Errors 
	 */
	public void registerManager(Manager manager) throws Errors {
		// create user and get id
		int id = UserDAO.registerUser(manager, 0);
		
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"INSERT INTO `MANAGER` (USERID, ExpInYear)VALUES (?, ?);");
			
			query.setInt(1, id);
			query.setInt(2, manager.getExpInYear());
			query.executeUpdate();
		} catch (SQLException e) {
			throw new Errors(1000);
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}
}
