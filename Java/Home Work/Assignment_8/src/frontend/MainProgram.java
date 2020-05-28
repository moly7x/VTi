package frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entity.Bee;
import entity.Drone;
import entity.Queen;
import entity.Worker;
import utils.BoxUtil;
import utils.ScannerUtil;

public class MainProgram {
	static List<Bee> bee = new ArrayList<Bee>();

	// create instance of Random class
	static Random rand = new Random();
	
	static int choice() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			return ScannerUtil.readInt(scanner, "Input must be Integer!\nPlease input again!\nYour choice: ");
		}
	}

	static void createBee() {
		bee.clear();
		for (int index = 0; index < 10; ++index) {
			// Generate random integers in range 0 to 2
			int type = rand.nextInt(3);

			switch (type) {
			case 0:
				bee.add(new Queen());
			case 1:
				bee.add(new Worker());
			default:
				bee.add(new Drone());
			}
		}
	}

	static void printTitle() {
		System.out.printf("%-11s%-9s%-10s%-11s%-11s\n", "Serial", "Type", "Limit", "Health", "Status");
		System.out.printf(String.format("%52s\n", "-").replace(" ", "-"));
	}

	static void printBee() {
		for (int index = 0; index < 10; ++index) {
			System.out.println(bee.get(index).toString(index));
		}
		System.out.println("");
	}

	static int damageBee() {
		// Generate random integers in range 0 to 80
		int dam = rand.nextInt(81);

		for (int index = 0; index < 10; ++index) {
			bee.get(index).Damage(dam);
		}
		printTitle();
		printBee();
		
		return dam;
	}

	public static void main(String[] args) {
		// Start first time
		createBee();
		printTitle();
		printBee();
		
		while (true) {
			String[] menu = new String[] { "1- Create new list", "2- Damage Bee", "3- Exit"};
			BoxUtil.createBox(menu);

			System.out.printf("Your choice: ");
			int choice = choice();
			switch (choice) {
			case 1:
				createBee();
				printTitle();
				printBee();
				break;
			case 2:
				System.out.println("Damage: " + damageBee());
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}

}
