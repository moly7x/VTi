package backend.bussinesslayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import backend.datalayer.DataManager;
import entity.Staff;

public class StaffService {
	public static List<Staff> staff = new ArrayList<Staff>();
	private static DataManager data_manager = new DataManager();

	/**
	 * This method is read staff from file at first time run program and move it to
	 * list staff
	 */
	public static boolean startStaff() {
		return data_manager.readStaffFile();
	}

	/**
	 * This method is create Staff to the list. UNKOWN FALSE!!
	 * 
	 * @return True if create profile success
	 */
	public boolean createStaff(String fullname, String department, float working_time, float salary_multiplier,
			int position, int allowance, float salary) {
		staff.add(new Staff(fullname, department, working_time, salary_multiplier, position, allowance, salary));
		data_manager.writeStaffFile();
		return true;
	}

	/**
	 * This method is checking Professor list
	 * 
	 * @return True if at least 1 element in Professor list
	 */
	public boolean checkStaff() {
		if (StaffService.staff.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * This method is searchProfessor by name, find it in list
	 * 
	 * @return True if it have result
	 */
	public boolean searchStaff(String name) {
		// Check the list is blank or not
		if (!checkStaff()) {
			return false;
		}

		// Check the list has at least 1 name which looking for
		boolean check = false;
		for (int index = 0; index < StaffService.staff.size(); ++index) {
			if (StaffService.staff.get(index).getFullname().contains(name)) {
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
		for (int index = 0; index < StaffService.staff.size(); ++index) {
			if (StaffService.staff.get(index).getFullname().contains(name)) {
				System.out.println(StaffService.staff.get(index));
			}
		}
		return true;
	}
	
	/**
	 * 
	 * This method is finding department. 
	 * 
	 * @author: Tân
	 * @create_date: 24/03/2020
	 * @param name
	 * @return
	 */
	public boolean searchDepartment(String deparment) {
		// Check the list is blank or not
		if (!checkStaff()) {
			return false;
		}

		// Check the list has at least 1 name which looking for
		boolean check = false;
		for (int index = 0; index < StaffService.staff.size(); ++index) {
			if (StaffService.staff.get(index).getDepartment().contains(deparment)) {
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
		for (int index = 0; index < StaffService.staff.size(); ++index) {
			if (StaffService.staff.get(index).getDepartment().contains(deparment)) {
				System.out.println(StaffService.staff.get(index));
			}
		}
		return true;
	}

	/**
	 * This method is print Title Result
	 */
	void printTitleResult() {
		System.out.printf("%-20s%-20s%-17s%-22s%-13s%-14s%s\n", "Full Name", "Department", "Working time",
				"Salary multiplier", "Position", "Allowance", "Salary");
		System.out.printf(String.format("%117s\n", "-").replace(" ", "-"));
	}
	
	/**
	 * This method is print professor
	 * 
	 * @return true if list professor not blank
	 */
	public boolean printProfessor() {
		// Check the list is blank or not
		if (!checkStaff()) {
			return false;
		}
		//Print title
		printTitleResult();
		
		//Sort before print
		Collections.sort(staff);
		
		for (int index = 0; index < StaffService.staff.size(); ++index) {
			System.out.println(StaffService.staff.get(index));
		}
		return true;
	}
}
