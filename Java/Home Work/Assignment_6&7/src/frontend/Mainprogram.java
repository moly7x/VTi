package frontend;

import backend.presentationlayer.ProfessorController;
import backend.presentationlayer.StaffController;

public class Mainprogram {
	public static void main(String[] args) {
		ProfessorController.startProfessor();
		StaffController.startStaff();
		Menu menu = new Menu();
		menu.createMainMenu();
	}
}
