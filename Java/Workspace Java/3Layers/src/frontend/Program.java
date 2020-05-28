package frontend;

import java.util.Scanner;

import backend.presentationlayer.UserController;
import entity.User;
import utils.ScannerUtil;

public class Program {
	public static void main(String[] args) {
		// nhap thong tin nguoi dung
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input name: ");
		String name = ScannerUtil.readString(scanner, "Please input data as string, Please input again: ");

		System.out.println("Please input age: ");
		int age = ScannerUtil.readInt(scanner, "Please input data as age, Please input again: ");

		User user = new User(name, age);

		// create user by UserController
		UserController userController = new UserController();
		try {
			boolean result = userController.createUser(user);
			System.out.println(result ? "Create successfully!" : "Create failured!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Please input again.");
		}
	}
}
