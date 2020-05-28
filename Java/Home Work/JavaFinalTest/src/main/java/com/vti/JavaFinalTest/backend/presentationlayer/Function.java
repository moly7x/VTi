//
package com.vti.JavaFinalTest.backend.presentationlayer;

import com.vti.JavaFinalTest.backend.businesslayer.EmployeeService;
import com.vti.JavaFinalTest.backend.businesslayer.ManagerService;
import com.vti.JavaFinalTest.backend.businesslayer.UserService;
import com.vti.JavaFinalTest.entity.Employee;
import com.vti.JavaFinalTest.entity.Manager;
import com.vti.JavaFinalTest.frontend.Errors;
import com.vti.JavaFinalTest.frontend.Print;

/**
 * This class is controller menu.
 * 
 * @author: Tân
 * @create_date: 30/03/2020
 */
public class Function {
	/**
	 * 
	 * This method controller register. 
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 */
	static void register() {
		String firstname = Print.getFirstName();
		String lastname = Print.getLastName();

		String email = Print.getEmail();
		String phone = Print.getPhone();
		String password = Print.getPassword();
		int role = Print.getRole();

		switch (role) {
		case 0:
			int ExpInYear = Print.getExpInYear();
			Manager manager = new Manager(firstname, lastname, email, phone, password, role, ExpInYear);
			
			try {
				ManagerService.registerManager(manager);
				Print.printMessage("Register Successfully");
			} catch (Errors e) {
				Print.printErrors(e);
			}
			break;
		case 1:
			int projectName = Print.getProjectName();
			String proSkill = Print.getProskill();
			Employee employee = new Employee(firstname, lastname, email, phone, password, role, projectName, proSkill);
			
			try {
				EmployeeService.registerEmployee(employee);
				Print.printMessage("Register Successfully");
			} catch (Errors e) {
				Print.printErrors(e);
			}
			break;
		}
	}
	
	/**
	 * 
	 * This method is controller login. 
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 */
	static void login() {
		String email = Print.loginEmail();
		String password = Print.loginPassword();
		try {
			String result = UserService.login(email, password);
			System.out.println("Login successful!");
			if (result == "Manager") {
				managerMenu(email, password);
			}else {
				employeeMenu(email, password);
			}
		} catch (Errors e) {
			Print.printErrors(e);
		}
	}
	
	/**
	 * 
	 * This method controller manager menu . 
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @param email
	 * @param password
	 */
	static void managerMenu(String email, String password) {
		while (true) {
			int choice = Print.printManagerMenu();
			switch (choice) {
			case 1:
				return;
			}
		}
	}
	
	/**
	 * 
	 * This method controller employee menu . 
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @param email
	 * @param password
	 */
	static void employeeMenu(String email, String password) {
		while (true) {
			int choice = Print.printEmployeeMenu();
			switch (choice) {
			case 1:
				return;
			}
		}
	}
}
