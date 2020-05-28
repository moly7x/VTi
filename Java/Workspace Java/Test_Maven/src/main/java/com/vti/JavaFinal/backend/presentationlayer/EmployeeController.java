//
package com.vti.JavaFinal.backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.JavaFinal.backend.businesslayer.EmployeeService;
import com.vti.JavaFinal.backend.businesslayer.IEmployeeService;
import com.vti.JavaFinal.entity.User;
import com.vti.JavaFinal.utils.ScannerUtil;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class EmployeeController implements IEmployeeController{
	static IEmployeeService employeeService;

	/**
	 * Constructor for class ManagerController.
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 */
	public EmployeeController() {
		employeeService = new EmployeeService();
	}

	/*
	 * @see
	 * com.vti.JavaFinal.backend.presentationlayer.IManagerController#register()
	 */
	@Override
	public void register() throws SQLException, IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("First name: ");
		String firstname = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
		System.out.printf("Last name: ");
		String lastname = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");

		String phone = "";
		while (!User.checkPhone(phone)) {
			System.out.printf("Phone number: ");
			phone = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
			if (!User.checkPhone(phone)) {
				System.out.println("Phone number is not correct!! Please try again.");
			}
		}

		String email = "";
		while (!User.checkEmail(email)) {
			System.out.printf("Email: ");
			email = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
			if (!User.checkEmail(email)) {
				System.out.println("Email is not correct!! Please try again.");
			}
		}

		int projectname = 0;
		System.out.printf("1- Testing System\n2- CMR\n3- Timesheet\n");
		while (!(projectname == 1 || projectname == 2 || projectname == 3)) {
			System.out.printf("Project: ");
			projectname = ScannerUtil.readInt(scanner,
					"Input must be Integer!\nPlease input again!\nProject: ");
			if (!(projectname == 1 || projectname == 2 || projectname == 3)) {
				System.out.println("Input only 1, 2 or 3!!!");
			}
		}
		
		System.out.printf("Proskill: ");
		String proskill = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
		
		String pass = "";
		while (!User.checkPass(pass)) {
			System.out.printf("Password: ");
			pass = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
			if (!User.checkPass(pass)) {
				System.out.println("Pass is not correct!! Please try again.");
			}
		}
		
		try {
			employeeService.register(firstname, lastname, phone, email, projectname, proskill, pass);
		} catch (SQLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

	/* 
	* @see com.vti.JavaFinal.backend.presentationlayer.IEmployeeController#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String email, String pass) throws SQLException, IOException {
		if (!employeeService.login(email, pass)) {
			return false;
		} else {
			return true;
		}
	}
}
