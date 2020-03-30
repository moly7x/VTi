package backend.bussinesslayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import backend.datalayer.DataManager;
import entity.Professor;

public class ProfessorService {
	public static List<Professor> professor = new ArrayList<Professor>();
	private static DataManager data_manager = new DataManager();

	/**
	 * This method is read professor from file at first time run program and move it
	 * to list professor
	 */
	public static boolean startProfessor() {
		return data_manager.readProfessorFile();
	}

	/**
	 * This method is create Professor to the list. UNKOWN FALSE!!
	 * 
	 * @return True if create profile success
	 */
	public boolean createProfessor(String fullname, String faculty, int academic_degree, int allowance,
			float monthly_teaching_time, float salary_multiplier, float salary) {
		professor.add(new Professor(fullname, faculty, academic_degree, allowance, monthly_teaching_time,
				salary_multiplier, salary));
		data_manager.writeProfessorFile();
		return true;
	}

	/**
	 * This method is checking Professor list
	 * 
	 * @return True if at least 1 element in Professor list
	 */
	public boolean checkProfessor() {
		if (ProfessorService.professor.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * This method is searchProfessor by name, find it in list
	 * 
	 * @return True if it have result
	 */
	public boolean searchProfessor(String name) {
		// Check the list is blank or not
		if (!checkProfessor()) {
			return false;
		}

		// Check the list has at least 1 name which looking for
		boolean check = false;
		for (int index = 0; index < ProfessorService.professor.size(); ++index) {
			if (ProfessorService.professor.get(index).getFullname().contains(name)) {
				check = true;
				break;
			}
		}
		// If has at least 1 name, print title of result
		if (!check) {
			return false;
		} else {
			printTitleResult();
		}

		// print the name same name looking for
		for (int index = 0; index < ProfessorService.professor.size(); ++index) {
			if (ProfessorService.professor.get(index).getFullname().contains(name)) {
				System.out.println(ProfessorService.professor.get(index));
			}
		}
		return true;
	}

	/**
	 * This method is print Title Result
	 */
	void printTitleResult() {
		System.out.printf("%-20s%-20s%-20s%-14s%-26s%-22s%s\n", "Full Name", "Faculty", "Academic degree", "Allowance",
				"Monthly teaching time", "Salary multiplier", "Salary");
		System.out.printf(String.format("%133s\n", "-").replace(" ", "-"));
	}

	/**
	 * This method is print professor
	 * 
	 * @return true if list professor not blank
	 */
	public boolean printProfessor() {
		// Check the list is blank or not
		if (!checkProfessor()) {
			return false;
		}
		//Print title
		printTitleResult();
		
		//Sort before print
		Collections.sort(professor);
		
		for (int index = 0; index < ProfessorService.professor.size(); ++index) {
			System.out.println(ProfessorService.professor.get(index));
		}
		return true;
	}
}