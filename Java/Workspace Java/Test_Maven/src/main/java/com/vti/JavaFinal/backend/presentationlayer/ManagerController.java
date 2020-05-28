//
package com.vti.JavaFinal.backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.JavaFinal.backend.businesslayer.IManagerService;
import com.vti.JavaFinal.backend.businesslayer.ManagerService;
import com.vti.JavaFinal.entity.User;
import com.vti.JavaFinal.utils.ScannerUtil;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class ManagerController implements IManagerController {
	static IManagerService managerService;

	/**
	 * Constructor for class ManagerController.
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 */
	public ManagerController() {
		managerService = new ManagerService();
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

		System.out.printf("Exp In Year: ");
		int expInYear = ScannerUtil.readInt(scanner, "Must be integer \nPlease try again: ");

		System.out.printf("Password: ");
		String pass = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");

		try {
			managerService.register(firstname, lastname, phone, email, expInYear, pass);
		} catch (SQLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public boolean login(String email, String pass) throws SQLException, IOException {
		if (!managerService.login(email, pass)) {
			return false;
		} else {
			return true;
		}
	}
}
