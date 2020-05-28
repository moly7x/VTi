//
package com.vti.JavaFinalTest.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.JavaFinalTest.entity.Employee;
import com.vti.JavaFinalTest.frontend.Errors;
import com.vti.JavaFinalTest.utils.DatabaseUtils;
import com.vti.JavaFinalTest.utils.ProjectUtils;

/**
 * This class is Employee Database.
 * 
 * @author: Tân
 * @create_date: 29/03/2020
 */
public class EmployeeDAO {
	/**
	 * 
	 * This method register Employee .
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param manager
	 * @throws Errors
	 */
	public void registerEmployee(Employee employee) throws Errors {
		// create user and get id
		int id = UserDAO.registerUser(employee, 1);

		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement("INSERT INTO `EMPLOYEE` (USERID, PROJECTNAME, PROSKILL)VALUES (?, ?, ?);");

			query.setInt(1, id);
			query.setString(2, ProjectUtils.getName(employee.getProjectName()));
			query.setString(3, employee.getProSkill());
			
			query.executeUpdate();
		} catch (SQLException e) {
			throw new Errors(1000);
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}
}
