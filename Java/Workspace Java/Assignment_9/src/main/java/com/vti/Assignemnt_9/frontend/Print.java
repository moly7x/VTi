//
package com.vti.Assignemnt_9.frontend;

import java.util.Scanner;

import com.vti.Assignemnt_9.Entity.User;
import com.vti.Assignemnt_9.backend.businesslayer.Valid;
import com.vti.Assignemnt_9.utils.ScannerUtil;

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
	 * This method getting user's account .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @return first name
	 */
	public static String getAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Account: ");
		return ScannerUtil.readString(scanner, "Can't not be null! Please try again.\nAccount: ");
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
	 * This method printing message .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @param message
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printUser(User user) {
		System.out.printf("%-11s%-14s%-14s%-9s\n", "Account", "Fist name", "Last name", "Email");
		System.out.printf(String.format("%49s\n", " ").replace(" ", "-"));
		System.out.printf("%-11s%-14s%-14s%-9s", user.getAccount(), user.getFirst_name(), user.getLast_name(), user.getEmail());
	}
}
