//
package com.vti.JavaFinalTest.frontend;

import java.util.Scanner;

import com.vti.JavaFinalTest.utils.ScannerUtil;
import com.vti.JavaFinalTest.backend.businesslayer.Valid;
import com.vti.JavaFinalTest.utils.BoxUtil;
import com.vti.JavaFinalTest.utils.ProjectUtils;

/**
 * This class is output of program.
 * 
 * @author: Tân
 * @create_date: 30/03/2020
 */
public class Print {
	static int choice() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			return ScannerUtil.readInt(scanner, "Input must be Integer! Please input again!\nYour choice: ");
		}
	}

	/**
	 * 
	 * This method creating main menu .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return choice of user
	 */
	public static int createMainMenu() {
		int choice = 0;
		while (true) {
			// printing menu
			String[] menu = new String[] { "1- Login", "2- Register", "3- Exit" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			choice = choice();
			if (choice == 1 || choice == 2 || choice == 3) {
				return choice;
			}
		}
	}

	/**
	 * 
	 * This method printing Errors message .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @param e
	 */
	public static void printErrors(Errors e) {
		System.out.println(e.getMessage());
	}

	/**
	 * 
	 * This method getting user's first name .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return first name
	 */
	public static String getFirstName() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("First name: ");
		return ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nFirst name: ");
	}

	/**
	 * 
	 * This method getting user's last name .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return last name
	 */
	public static String getLastName() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Last name: ");
		return ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nLast name: ");
	}

	/**
	 * 
	 * This method getting user's email and check valid.
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return email
	 */
	public static String getEmail() {
		Scanner scanner = new Scanner(System.in);
		String email;
		while (true) {
			System.out.printf("Email: ");
			email = ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nEmail: ");
			try {
				Valid.checkEmail(email);
				return email;
			} catch (Errors e) {
				printErrors(e);
			}
		}
	}

	/**
	 * 
	 * This method get email from user and don't check valid.
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return
	 */
	public static String loginEmail() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.printf("Email: ");
			return ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nEmail: ");
		}
	}

	/**
	 * 
	 * This method getting user's phone number.
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return email
	 */
	public static String getPhone() {
		Scanner scanner = new Scanner(System.in);
		String phone;
		while (true) {
			System.out.printf("Phone Number: ");
			phone = ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nPhone Number: ");
			try {
				Valid.checkPhone(phone);
				return phone;
			} catch (Errors e) {
				printErrors(e);
			}
		}

	}

	/**
	 * 
	 * This method getting user's password.
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return email
	 */
	public static String getPassword() {
		Scanner scanner = new Scanner(System.in);
		String pass1;
		String pass2;
		while (true) {
			do {
				System.out.printf("Password: ");
				pass1 = ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nPassword: ");
				System.out.printf("Confirm password: ");
				pass2 = ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nPassword: ");
				if (!pass1.equals(pass2)) {
					System.out.println("Two passwords didn't same. Please try again!!");
				}
			} while (!pass1.equals(pass2));

			try {
				Valid.checkStrengthPassword(pass1);
				return pass1;
			} catch (Errors e) {
				printErrors(e);
			}
		}
	}

	/**
	 * 
	 * This method get password from user and don't check valid.
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return
	 */
	public static String loginPassword() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.printf("Password: ");
			return ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nPassword: ");
		}
	}

	/**
	 * 
	 * This method getting role .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return
	 */
	public static int getRole() {
		Scanner scanner = new Scanner(System.in);
		int role;
		String[] name_of_role = { "0- Manager", "1- Employee" };
		while (true) {
			BoxUtil.createBox(name_of_role);
			System.out.print("Your choice: ");
			role = ScannerUtil.readInt(scanner, "It must be integer! Please try again.\nYour choice: ");

			if (role == 0 || role == 1) {
				return role;
			}
		}
	}

	/**
	 * 
	 * This method getting Exp In year .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return
	 */
	public static int getExpInYear() {
		Scanner scanner = new Scanner(System.in);
		int ExpInYear;
		while (true) {
			System.out.printf("ExpInYear: ");
			ExpInYear = ScannerUtil.readInt(scanner, "Can't not be null! Please try again.\nExpInYear: ");
			try {
				Valid.checkExpInYear(ExpInYear);
				return ExpInYear;
			} catch (Errors e) {
				printErrors(e);
			}
		}

	}

	/**
	 * 
	 * This method getting Project name from user .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return
	 */
	public static int getProjectName() {
		Scanner scanner = new Scanner(System.in);
		int projectName;

		// Get list name of project
		String[] name_of_project = null;
		try {
			name_of_project = ProjectUtils.getListProject();
		} catch (Errors e) {
			printErrors(e);
		}
		while (true) {
			BoxUtil.createBox(name_of_project);
			System.out.println("Your choice: ");
			projectName = ScannerUtil.readInt(scanner, "It must be integer! Please try again.\nYour choice: ");
			try {
				Valid.checkProjectName(projectName);
				return projectName;
			} catch (Errors e) {
				printErrors(e);
			}
		}
	}

	/**
	 * 
	 * This method getting proskill.
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return
	 */
	public static String getProskill() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Proskill ");
		return ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nProSkill: ");
	}

	/**
	 * 
	 * This method printing message .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @param message
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}

	/**
	 * 
	 * This method is print manager menu.
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 */
	public static int printManagerMenu() {
		int choice = 0;
		while (true) {
			// printing menu
			String[] menu = new String[] { "This is manager Menu", "1- Logout" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			choice = choice();
			if (choice == 1) {
				return choice;
			}
		}
	}
	
	/**
	 * 
	 * This method is print employee menu.
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 */
	public static int printEmployeeMenu() {
		int choice = 0;
		while (true) {
			// printing menu
			String[] menu = new String[] { "This is employee Menu", "1- Logout" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			choice = choice();
			if (choice == 1) {
				return choice;
			}
		}
	}
}
