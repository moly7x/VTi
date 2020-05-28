package com.vti.JavaFinalTest.backend.presentationlayer;

import com.vti.JavaFinalTest.frontend.Errors;
import com.vti.JavaFinalTest.frontend.Print;

public class AppController {
	public static void main(String[] args) throws Errors {
		while (true) {
			int choice = Print.createMainMenu();
			switch (choice) {
			case 1:
				Function.login();
				break;
			case 2:
				Function.register();
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}
}
