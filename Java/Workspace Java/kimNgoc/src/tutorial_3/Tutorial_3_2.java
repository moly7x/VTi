//
package tutorial_3;

import java.util.Scanner;

public class Tutorial_3_2 {

	public static void main(String[] args) {
		// open scanner, input from system.in
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter pagagraph: ");
		String string1 = scan.nextLine();

		scan.close();

		// step 1
		string1 = string1.replace("  ", " ");

		// step 2
		string1 = string1.replace(". ", ".");

		// step 3
		string1 = string1.replace(".", ". ");

		// step 4, replace last space at the end of string
		string1 = string1.trim();

		System.out.println("Result:\n" + string1);
	}

}
