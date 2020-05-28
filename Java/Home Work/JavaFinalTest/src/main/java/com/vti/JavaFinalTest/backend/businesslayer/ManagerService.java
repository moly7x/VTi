//
package com.vti.JavaFinalTest.backend.businesslayer;

import com.vti.JavaFinalTest.backend.datalayer.ManagerDAO;
import com.vti.JavaFinalTest.entity.Manager;
import com.vti.JavaFinalTest.frontend.Errors;

/**
 * This class is logical manager. 
 * 
 * @author: Tân
 * @create_date: 30/03/2020
 */
public class ManagerService {
	public static void registerManager(Manager manager) throws Errors {
		ManagerDAO managerDAO = new ManagerDAO();
		managerDAO.registerManager(manager);
	}
}
