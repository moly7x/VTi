//
package tutorial_4;

import java.util.Scanner;

public class Tutorial_4_2 {
	public static void main(String[] args) {
		// open scanner, input from system.in
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a: ");
		double a = scan.nextDouble();

		System.out.print("Enter b: ");
		double b = scan.nextDouble();

		System.out.print("Enter c: ");
		double c = scan.nextDouble();

		// close scanner
		scan.close();

		if (a == 0 && b == 0) {
			System.out.println("Can't slove!!");
		} else if (a == 0) {
			System.out.printf("The given equation has one solution is %.2f.", -c / b);
		} else {
			double delta = b * b - 4 * a * c;

			if (delta > 0) {
				double x = ((-b - Math.sqrt(delta)) / (2 * a));
				System.out.printf("The given equation has two solutions are %.2f and %.2f.", x, -b / a - x);
			} else if (delta == 0) {
				double x = ((-b - Math.sqrt(delta)) / (2 * a));
				System.out.printf("The given equation has one solution is %.2f.", x);
			} else {
				System.out.println("The given equation has no reals solution.");
			}
		}

	}
}
