//
package com.vti.JavaFinalTest.backend.businesslayer;

import com.vti.JavaFinalTest.backend.datalayer.EmployeeDAO;
import com.vti.JavaFinalTest.entity.Employee;
import com.vti.JavaFinalTest.frontend.Errors;

/**
 * This class logical employee . 
 * 
 * @author: Tân
 * @create_date: 30/03/2020
 */
public class EmployeeService {
	public static void registerEmployee(Employee employee) throws Errors {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.registerEmployee(employee);
	}
}
