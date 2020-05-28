package backend.datalayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import backend.bussinesslayer.ProfessorService;
import backend.bussinesslayer.StaffService;
import entity.Professor;
import entity.Staff;

public class DataManager {
	static final String FOLDER_NAME = "Data";
	static final String PROFESSOR_FILE = dirLocation() + "\\Data\\professor.txt";
	static final String STAFF_FILE = dirLocation() + "\\Data\\staff.txt";

	/**
	 * This method get file location now.
	 * 
	 * @return String is file location
	 */
	public static String dirLocation() {
		return System.getProperty("user.dir");
	}

	/**
	 * This method is check folder Data, if exists return true.
	 */
	boolean existFolder() {
		File theDir = new File(FOLDER_NAME);
		if (theDir.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is create folder Data
	 * 
	 * @return True if success else is false
	 */
	boolean createFolder() {
		File folder = new File(FOLDER_NAME);

		// if the folder does not exist, create it
		try {
			folder.mkdir();
			return true;
		} catch (SecurityException se) {
			System.out.println("Can't create folder!!");
			return false;
		}

	}

	/**
	 * This method is check file in folder Data, if exists return true.
	 */
	boolean existFile(String dir) {
		File file = new File(dir);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is create Professor File
	 * 
	 * @return True if success else is false
	 */
	boolean createFile(String dir) {
		// Create folder if not exist
		if (!existFolder()) {
			createFolder();
		}

		// Create file
		try {
			File file = new File(dir);
			file.createNewFile();
			return true;
		} catch (IOException e) {
			System.out.println("An error When create file data. " + e);
			return false;
		}
	}

	/**
	 * This method delete Professor File
	 * 
	 * @return True if success else is false
	 */
	boolean deleteFile(String dir) {
		File file = new File(dir);
		if (file.delete()) {
			return true;
		} else {
			return false;
		}
	}

// PROFESSOR ---------------------------------
	/**
	 * This method is write to Professor file
	 */
	public void writeProfessorFile() {
		// Create new professor file
		if (!existFile(PROFESSOR_FILE)) {
			createFile(PROFESSOR_FILE);
		}

		try {
			FileWriter professor = new FileWriter(PROFESSOR_FILE, true);
			int last_pos = ProfessorService.professor.size() - 1;

			// if this is not first line must have enter
			if (last_pos != 0) {
				professor.write("\n");
			}
			professor.write(ProfessorService.professor.get(last_pos).getFullname() + ","
					+ ProfessorService.professor.get(last_pos).getFaculty() + ","
					+ ProfessorService.professor.get(last_pos).getAcademic_degree() + ","
					+ ProfessorService.professor.get(last_pos).getAllowance() + ","
					+ ProfessorService.professor.get(last_pos).getMonthly_teaching_time() + ","
					+ ProfessorService.professor.get(last_pos).getSalary_multiplier() + ","
					+ ProfessorService.professor.get(last_pos).getSalary());
			professor.close();
			System.out.println("Successfully saved to the Professor file.");
		} catch (IOException e) {
			System.out.println("An error to write to Professor file" + e);
		}
	}

	/**
	 * This method is read from Professor file and import it to list
	 */
	public boolean readProfessorFile() {
		if (!existFolder() || !existFile(PROFESSOR_FILE)) {
			// Create new professor file
			createFile(PROFESSOR_FILE);
			return true;
		}
		// Create new professor file
		try {
			File file = new File(PROFESSOR_FILE);
			Scanner scanner = new Scanner(file);
			// if still has next line, read it and import to professor list
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				if (!inputProfessor(data)) {
					scanner.close();
					deleteFile(PROFESSOR_FILE);
					createFile(PROFESSOR_FILE);
					return false;
				}
			}
			scanner.close();
			System.out.println("Started Professor successfully!!");
		} catch (FileNotFoundException e) {
			System.out.println("File Professor is not found!!!");
			return false;
		}
		return true;
	}

	/**
	 * This method is import element to Professor list
	 * 
	 * @param data String, one line from text file
	 * @return true if success
	 */
	boolean inputProfessor(String data) {
		String[] input = data.split("[,]");
		try {
			String fullname = input[0];
			String faculty = input[1];
			int academic_degree = Integer.parseInt(input[2]);
			int allowance = Integer.parseInt(input[3]);
			float monthly_teaching_time = Float.parseFloat(input[4]);
			float salary_multiplier = Float.parseFloat(input[5]);
			float salary = Float.parseFloat(input[6]);
			ProfessorService.professor.add(new Professor(fullname, faculty, academic_degree, allowance,
					monthly_teaching_time, salary_multiplier, salary));
			return true;
		} catch (Exception e) {
			ProfessorService.professor.clear();
			System.out.println("File Old Staff has been broken. Can't read. It will be deleted and recreated!!!");
			return false;
		}

	}

// Staff ---------------------------------
	/**
	 * This method is write to Staff file
	 */
	public void writeStaffFile() {
		// Create new professor file
		if (!existFile(STAFF_FILE)) {
			createFile(STAFF_FILE);
		}

		try {
			FileWriter staff = new FileWriter(STAFF_FILE, true);
			int last_pos = StaffService.staff.size() - 1;

			// if this is not first line must have enter
			if (last_pos != 0) {
				staff.write("\n");
			}
			staff.write(StaffService.staff.get(last_pos).getFullname() + ","
					+ StaffService.staff.get(last_pos).getDepartment() + ","
					+ StaffService.staff.get(last_pos).getWorking_time() + ","
					+ StaffService.staff.get(last_pos).getSalary_multiplier() + ","
					+ StaffService.staff.get(last_pos).getPosition() + ","
					+ StaffService.staff.get(last_pos).getAllowance() + ","
					+ StaffService.staff.get(last_pos).getSalary());
			staff.close();
			System.out.println("Successfully saved to the Staff file.");
		} catch (IOException e) {
			System.out.println("An error to write to Staff file" + e);
		}
	}

	/**
	 * This method is read from Professor file and import it to list
	 */
	public boolean readStaffFile() {
		if (!existFolder() || !existFile(STAFF_FILE)) {
			// Create new professor file
			createFile(STAFF_FILE);
			return true;
		}
		// Create new professor file
		try {
			File file = new File(STAFF_FILE);
			Scanner scanner = new Scanner(file);
			// if still has next line, read it and import to professor list
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				if (!inputStaff(data)) {
					scanner.close();
					deleteFile(STAFF_FILE);
					createFile(STAFF_FILE);
					return false;
				}
			}
			scanner.close();
			System.out.println("Started Staff successfully!!");
		} catch (FileNotFoundException e) {
			System.out.println("File Staff is not found!!!");
			return false;
		}
		return true;
	}

	/**
	 * This method is import element to Staff list
	 * 
	 * @param data String, one line from text file
	 * @return true if success
	 */
	boolean inputStaff(String data) {
		String[] input = data.split("[,]");
		try {
			String fullname = input[0];
			String department = input[1];
			float working_time = Float.parseFloat(input[2]);
			float salary_multiplier = Float.parseFloat(input[3]);
			int position = Integer.parseInt(input[4]);
			int allowance = Integer.parseInt(input[5]);
			float salary = Float.parseFloat(input[6]);

			StaffService.staff
					.add(new Staff(fullname, department, working_time, salary_multiplier, position, allowance, salary));
			return true;
		} catch (Exception e) {
			StaffService.staff.clear();
			System.out.println("File Old Staff has been broken. Can't read. It will be deleted and recreated!!!");
			return false;
		}

	}
}