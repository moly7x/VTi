package frontend;

import java.util.Scanner;

import backend.presentationlayer.ProfessorController;
import backend.presentationlayer.StaffController;
import utils.BoxUtil;
import utils.ScannerUtil;

public class Menu {
	/**
	 * Constructor for class Menu.
	 * 
	 * @author: T�n
	 * @create_date: 24/03/2020
	 */
	static ProfessorController professor;
	static StaffController staff;

	public Menu() {
		professor = new ProfessorController();
		staff = new StaffController();
	}

	/**
	 * This method get the number of choice .
	 * 
	 * @author: T�n
	 * @create_date: 23/03/2020
	 * @return number of choice
	 */
	int choice() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			return ScannerUtil.readInt(scanner, "Input must be Integer!\nPlease input again!\nYour choice: ");
		}
	}

	/**
	 * This method is creating the menu
	 */
	void createMainMenu() {
		while (true) {
			String[] menu = new String[] { "1- Add element list", "2- Search", "3- Print", "4- Exit" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			int choice = choice();
			switch (choice) {
			case 1:
				createAddMenu();
				break;
			case 2:
				createSearchMenu();
				break;
			case 3:
				createPrintMenu();
				break;
			case 4:
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * This method is create Add element menu
	 */
	void createAddMenu() {
		while (true) {
			String[] menu = new String[] { "1- Add element to Proffessor list", "2- Add element to Staff list",
					"3- Return" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			int choice = choice();
			switch (choice) {
			case 1:
				professor.createProfessor();
				break;
			case 2:
				staff.createStaff();
				break;
			case 3:
				return;
			}
		}

	}

	/**
	 * This method is create Search Menu.
	 * 
	 * @Description: .
	 * @author: T�n
	 * @create_date: 23/03/2020
	 */
	void createSearchMenu() {
		while (true) {
			String[] menu = new String[] { "1- By name",
					"2- By Department (Only for one who belongs to the department!!!)", "3- Return" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			int choice = choice();
			switch (choice) {
			case 1:
				searchByName();
				break;
			case 2:
				staff.searchDepartment();
				break;
			case 3:
				return;
			}
		}
	}

	/**
	 * 
	 * This method is Search by name.
	 * 
	 * @author: T�n
	 * @create_date: 23/03/2020
	 */
	void searchByName() {
		while (true) {
			String[] menu = new String[] { "1- Search Professor", "2- Search Staff", "3- Return" };
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			int choice = choice();
			switch (choice) {
			case 1:
				professor.searchProfessor();
				break;
			case 2:
				staff.searchStaff();
				break;
			case 3:
				return;
			}
		}
	}

	/**
	 * 
	 * This method is Search by name.
	 * 
	 * @author: T�n
	 * @create_date: 23/03/2020
	 */
	void createPrintMenu() {
		while (true) {
			String[] menu = new String[] { "1- Print Professor","2- Print Staff","3- Return" };
			BoxUtil.createBox(menu);
			
			System.out.printf("Your choice: ");
			int choice = choice();
			switch (choice) {
			case 1:
				professor.printProfessor();
				break;
			case 2:
				staff.printStaff();
				break;
			case 3:
				return;
			}
		}
	}
}
