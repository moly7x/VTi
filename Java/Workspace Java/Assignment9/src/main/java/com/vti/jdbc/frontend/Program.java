//
package com.vti.jdbc.frontend;

import java.util.Scanner;
import com.vti.jdbc.backend.presentationlayer.TraineeController;
import com.vti.jdbc.utils.ScannerUtil;

/**
 * This class is .
 * 
 * @Description: .
 * @author: hung34atp
 * @create_date: Mar 23, 2020
 * @version: 1.0
 * @modifer: hung34atp
 * @modifer_date: Mar 23, 2020
 */
public class Program {

	public static void main(String[] args) {
		Function f = new Function();
		Scanner sc = new Scanner(System.in);
		int choose;

		while (true) {
			
			String userName = "";
			String passWord = "";
			System.out.println("UserName: ");
			userName = ScannerUtil.readString(sc, "Can't not null! \nPlease try again: ");
			System.out.println("PassWord: ");
			passWord = ScannerUtil.readString(sc, "Can't not null! \nPlease try again: ");
			boolean bl = new TraineeController().login(userName, passWord);
			if (!bl) {
				System.out.println("Please login again!");
			} else {
				System.out.println("Login successfully!");
				boolean login = true;
				while (login) {
					System.out.println("----------Welcome " + userName + "---------");
					System.out.println("1.	Get all Trainee.");
					System.out.println("2.	Insert Trainee.");
					System.out.println("3.	Update Trainee.");
					System.out.println("4.	Logout.");
					System.out.println("Please choose: ");
					choose = ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");
					switch (choose) {
					case 1:
						// get all Trainee
						f.getAllTrainee();
						break;
					case 2:
						// insert Trainee
						f.insertTrainee();
						break;
					case 3:
						// update Trainee
						f.updateTrainee();
						break;
					case 4:
						// logout
						login = false;
						System.out.println("Logout succesfully!");
						break;
					default:
						System.out.println("Please choose from 1-->4");
						break;
					}
				}
			}
		}
	}
}
