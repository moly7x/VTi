//
package com.vti.JavaFinal.frontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.JavaFinal.backend.presentationlayer.EmployeeController;
import com.vti.JavaFinal.backend.presentationlayer.IEmployeeController;
import com.vti.JavaFinal.backend.presentationlayer.IManagerController;
import com.vti.JavaFinal.backend.presentationlayer.ManagerController;
import com.vti.JavaFinal.entity.User;
import com.vti.JavaFinal.utils.BoxUtil;
import com.vti.JavaFinal.utils.ScannerUtil;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class Function {
	static IEmployeeController employeeController;
	static IManagerController managerController;

	/**
	 * Constructor for class Function.
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 */
	public Function() {
		employeeController = new EmployeeController();
		managerController = new ManagerController();
	}

	int choice() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			return ScannerUtil.readInt(scanner, "Input must be Integer!\nPlease input again!\nYour choice: ");
		}
	}

	public void createMenu() {
		while (true) {
			String[] menu = new String[] { "1- Login", "2- Register", "3- Exit" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			int choice = choice();
			switch (choice) {
			case 1:
				loginMenu();
				break;
			case 2:
				registerMenu();
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * This method is .
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 */
	private void registerMenu() {
		while (true) {
			String[] menu = new String[] { "1- Employee", "2- Manager", "3- Return" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			int choice = choice();
			switch (choice) {
			case 1:
				try {
					employeeController.register();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					managerController.register();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				return;
			}
		}

	}

	/**
	 * This method is .
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 */
	private void loginMenu() {
		Scanner scanner = new Scanner(System.in);

		String email = "";
		while (!User.checkEmail(email)) {
			System.out.printf("Email: ");
			email = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
			if (!User.checkEmail(email)) {
				System.out.println("Email is not correct!! Please try again.");
			}
		}

		String pass = "";
		while (!User.checkPass(pass)) {
			System.out.printf("Password: ");
			pass = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
			if (!User.checkPass(pass)) {
				System.out.println("Pass is not correct!! Please try again.");
			}
		}

		try {
			if (employeeController.login(email, pass) || managerController.login(email, pass)) {
				System.out.println("Login success!");
				System.exit(0);
			} else {
				System.out.println("Login is fail!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
