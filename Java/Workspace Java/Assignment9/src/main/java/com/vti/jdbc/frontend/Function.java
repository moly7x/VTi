//
package com.vti.jdbc.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.jdbc.backend.presentationlayer.TraineeController;
import com.vti.jdbc.entity.Trainee;
import com.vti.jdbc.utils.ScannerUtil;

/**
 * This class is .
 * 
 * @Description: .
 * @author: hung34atp
 * @create_date: Mar 24, 2020
 * @version: 1.0
 * @modifer: hung34atp
 * @modifer_date: Mar 24, 2020
 */
public class Function {
	static List<Trainee> list;

	public void getAllTrainee() {
		list = new TraineeController().getAllTrainee();
		for (Trainee t : list) {
			System.out.println(t.getId());
			System.out.println(t.getUserName());
			System.out.println(t.getFirstName());
			System.out.println(t.getLastName());
			System.out.println(t.getEmail());
			System.out.println("--------------------------------");
		}
	}
	
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 */
	public void insertTrainee() {
		Scanner sc = new Scanner(System.in);
		Trainee trainee = new Trainee();
		System.out.println("UserName: ");
		trainee.setUserName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("PassWord: ");
		trainee.setPassWord(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("FirstName: ");
		trainee.setFirstName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("LastName: ");
		trainee.setLastName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("Email: ");
		trainee.setEmail(ScannerUtil.readString(sc, "Not null! \nTry again"));
		
		boolean bl = new TraineeController().insertTrainee(trainee);
		if (bl) {
			System.out.println("Insert Successfully!");
		}else {
			System.out.println("Insert Failed!");
		}
	}
	
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 * @param userName
	 */
	public void updateTrainee() {
		Scanner sc = new Scanner(System.in);
		Trainee trainee = new Trainee();
		System.out.println("UserName: ");
		trainee.setUserName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("FirstName: ");
		trainee.setFirstName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("LastName: ");
		trainee.setLastName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("Email: ");
		trainee.setEmail(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("PassWord: ");
		trainee.setPassWord(ScannerUtil.readString(sc, "Not null! \nTry again"));
		boolean bl = new TraineeController().updateTrainee(trainee);
		if (bl) {
			System.out.println("Update Successfully!");
		}else {
			System.out.println("Update Failed!");
		}
	}
}
