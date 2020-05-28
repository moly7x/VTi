package backend.presentationlayer;

import java.util.Scanner;

import backend.bussinesslayer.StaffService;
import utils.ScannerUtil;

public class StaffController {
	private StaffService staffService;

	public StaffController() {
		staffService = new StaffService();
	}

	/**
	 * This method is read staff from file at first time run program
	 */
	public static boolean startStaff() {
		return StaffService.startStaff();
	}

	/**
	 * This method is input Staff profile and check. If all correct, it will move
	 * data to Professor service
	 *
	 */
	public void createStaff() {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("Full name: ");
		String fullname = ScannerUtil.readString(scanner, "Please input again: ");
		System.out.printf("Department: ");
		String department = ScannerUtil.readString(scanner, "Please input again: ");

		System.out.printf("Working Time: ");
		float working_time = ScannerUtil.readFloat(scanner,
				"Input must be Integer!\nPlease input again!\nWorking Time: ");

		System.out.printf("Salary Multiplier: ");
		float salary_multiplier = ScannerUtil.readFloat(scanner,
				"Input must be Integer!\nPlease input again!\nSalary Multiplier: ");

		int position = 0;
		System.out.printf("1- Department Head\n2- Vice Head\n3- Staff\n");
		while (!(position == 1 || position == 2 || position == 3)) {
			System.out.printf("Position: ");
			position = ScannerUtil.readInt(scanner, "Input must be Integer!\nPlease input again!\nPosition: ");
			if (!(position == 1 || position == 2 || position == 3)) {
				System.out.println("Input only 1, 2 or 3!!!");
			}
		}

		int allowance = 0;
		switch (position) {
		case 1:
			allowance = 2000;
			break;
		case 2:
			allowance = 1000;
			break;

		case 3:
			allowance = 500;
			break;
		}
		System.out.println("Allowance: " + allowance);

		float salary = salary_multiplier * 730 + allowance + working_time * 30;
		System.out.println("Salary: " + salary);

		// move data to Staff Service
		if (staffService.createStaff(fullname, department, working_time, salary_multiplier, position, allowance,
				salary)) {
			System.out.println("Create Staff profile successfully!!");
		}

	}

	/**
	 * This method is search Staff by name
	 * 
	 * @return True if it can find a part of name
	 */
	public boolean searchStaff() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Name: ");
		String name = ScannerUtil.readString(scanner, "Please input again: ");

		if (!staffService.searchStaff(name)) {
			System.out.println("Can't find that name!!!");
			return false;
		}
		return true;
	}
	
	/**
	 * This method is search Staff by department
	 * 
	 * @return True if it can find a part of name
	 */
	public boolean searchDepartment() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Department: ");
		String department = ScannerUtil.readString(scanner, "Please input again: ");

		if (!staffService.searchDepartment(department)) {
			System.out.println("Can't find that department!!!");
			return false;
		}
		return true;
	}
	
	/**
	 * This method is print Staff
	 */
	public void printStaff() {
		if (!staffService.printProfessor()) {
			System.out.println("Staff list is blank");
		};
	}
}