//
package tutorial_4;

import java.util.Scanner;

public class Tutorial_4_1 {

	public static void main(String[] args) {
		// open scanner, input from system.in
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Year: ");
		int y = scan.nextInt();

		// close scanner
		scan.close();

		boolean check = true;

		if (y % 4 != 0) {
			check = false;
		}

		if (!((y % 100 != 0) || (y % 100 == 0 && y % 400 == 0))) {
			check = false;
		}
		
		if (check) {
			System.out.println("It's leap year!");
		} else {
			System.out.println("It's not leap year!");
		}
	}

}
