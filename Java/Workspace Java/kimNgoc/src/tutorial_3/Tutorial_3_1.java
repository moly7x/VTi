//
package tutorial_3;

import java.util.Scanner;

public class Tutorial_3_1 {

	public static void main(String[] args) {
		// open scanner, input from system.in
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter string 1: ");
		String string1 = scan.nextLine();

		System.out.print("Enter string 2: ");
		String string2 = scan.nextLine();

		System.out.print("Enter string 3: ");
		String string3 = scan.nextLine();

		// close scanner
		scan.close();

		float num1 = 0, num2 = 0, num3 = 0;

		// process string 1
		if (string1.contains("VND")) {
			// get number only
			string1 = string1.substring(0, string1.length() - 4);
			// string to Float
			num1 = Float.valueOf(string1).floatValue();

			// convert VND to USD
			num1 = num1 / 23500;
		}

		if (string1.contains("EUR")) {
			// get number only
			string1 = string1.substring(0, string1.length() - 4);
			// string to Float
			num1 = Float.valueOf(string1).floatValue();

			// convert EUR to VND
			num1 = num1 * 27100;
			// convert VND to USD
			num1 = num1 / 23500;
		}

		if (string1.contains("$")) {
			// get number only
			string1 = string1.substring(1);
			// string to Float
			num1 = Float.valueOf(string1).floatValue();
		}

		// process string 2
		if (string2.contains("VND")) {
			// get number only
			string2 = string2.substring(0, string2.length() - 4);
			// string to Float
			num2 = Float.valueOf(string2).floatValue();

			// convert VND to USD
			num2 = num2 / 23500;
		}

		if (string2.contains("EUR")) {
			// get number only
			string2 = string2.substring(0, string2.length() - 4);
			// string to Float
			num2 = Float.valueOf(string2).floatValue();

			// convert EUR to VND
			num2 = num2 * 27100;
			// convert VND to USD
			num2 = num2 / 23500;
		}

		if (string2.contains("$")) {
			// get number only
			string2 = string2.substring(1);
			
			// string to Float
			num2 = Float.valueOf(string2).floatValue();
		}

		// process string 3
		if (string3.contains("VND")) {
			// get number only
			string3 = string3.substring(0, string3.length() - 4);
			// string to Float
			num3 = Float.valueOf(string3).floatValue();

			// convert VND to USD
			num3 = num3 / 23500;
		}

		if (string3.contains("EUR")) {
			// get number only
			string3 = string3.substring(0, string3.length() - 4);
			// string to Float
			num3 = Float.valueOf(string3).floatValue();

			// convert EUR to VND
			num3 = num3 * 27100;
			// convert VND to USD
			num3 = num3 / 23500;
		}

		if (string3.contains("$")) {
			// get number only
			string3 = string3.substring(1);
			// string to Float
			num3 = Float.valueOf(string3).floatValue();
		}
		
		// get 2 number after decimal point
		float sum = ((int) ((num1 + num2 + num3) * 100)) / 100f;
		
		System.out.println("$" + sum);
	}

}
