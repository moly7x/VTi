package backend.presentationlayer;

import java.util.Scanner;

import backend.bussinesslayer.ProfessorService;
import utils.ScannerUtil;

public class ProfessorController {

	private ProfessorService professorService;

	public ProfessorController() {
		professorService = new ProfessorService();
	}

	/**
	 * This method is read professor from file at first time run program
	 */
	public static boolean startProfessor() {
		return ProfessorService.startProfessor();
	}

	/**
	 * This method is input Professor profile and check. If all correct, it will
	 * move data to Professor service
	 *
	 */
	public void createProfessor() {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("Full name: ");
		String fullname = ScannerUtil.readString(scanner, "Please input again: ");
		System.out.printf("Faculty: ");
		String faculty = ScannerUtil.readString(scanner, "Please input again: ");

		int academic_degree = 0;
		System.out.printf("1- Bachelor\n2- Master\n3- Doctor\n");
		while (!(academic_degree == 1 || academic_degree == 2 || academic_degree == 3)) {
			System.out.printf("Academic Degree: ");
			academic_degree = ScannerUtil.readInt(scanner,
					"Input must be Integer!\nPlease input again!\nAcademic Degree: ");
			if (!(academic_degree == 1 || academic_degree == 2 || academic_degree == 3)) {
				System.out.println("Input only 1, 2 or 3!!!");
			}
		}

		int allowance = 0;
		switch (academic_degree) {
		case 1:
			allowance = 300;
			break;
		case 2:
			allowance = 500;
			break;

		case 3:
			allowance = 1000;
			break;
		}
		System.out.println("Allowance: " + allowance);

		System.out.printf("Monthly Teaching Time: ");
		float monthly_teaching_time = ScannerUtil.readFloat(scanner,
				"Input must be Integer!\nPlease input again!\nMonthly Teaching Time: ");

		System.out.printf("Salary Multiplier: ");
		float salary_multiplier = ScannerUtil.readFloat(scanner,
				"Input must be Integer!\nPlease input again!\nSalary Multiplier: ");

		float salary = salary_multiplier * 730 + allowance + monthly_teaching_time * 45;
		System.out.println("Salary: " + salary);

		// move data to Professor Service
		if (professorService.createProfessor(fullname, faculty, academic_degree, allowance, monthly_teaching_time,
				salary_multiplier, salary)) {
			System.out.println("Create Professor profile successfully!!");
		}

	}
	
	/**
	 * This method is searchProfessor by name
	 * 
	 * @return True if it can find a part of name
	 */
	public void searchProfessor() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Name: ");
		String name = ScannerUtil.readString(scanner, "Please input again: ");
		
		if (!professorService.searchProfessor(name)) {
			System.out.println("Can't find that name!!!");
		};
	}
	
	/**
	 * This method is print professor
	 */
	public void printProfessor() {
		if (!professorService.printProfessor()) {
			System.out.println("Professor list is blank");
		};
	}
}