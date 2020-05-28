//
package com.vti.JavaFinal.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;

import com.vti.JavaFinal.backend.datalayer.EmployeeDAO;
import com.vti.JavaFinal.backend.datalayer.IEmployeeDAO;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class EmployeeService implements IEmployeeService {
	static IEmployeeDAO employeeDao;

	/**
	 * Constructor for class Employee Service.
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 */
	public EmployeeService() {
		employeeDao = new EmployeeDAO();
	}

	@Override
	public boolean register(String firstname, String lastname, String phone, String email, int projectName,
			String proSkill, String pass) throws SQLException, IOException {
		try {
			return employeeDao.register(firstname, lastname, phone, email, projectName, proSkill, pass);
		} catch (SQLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}

	}

	/*
	 * @see
	 * com.vti.JavaFinal.backend.businesslayer.IEmployeeService#login(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public boolean login(String email, String pass) throws SQLException, IOException {
		if (!employeeDao.login(email, pass)) {
			return false;
		} else
			return true;
	}
}
