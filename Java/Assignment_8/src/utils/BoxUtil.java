//
package utils;

/**
 * This class is Create a box.
 * 
 * @author: Tân
 * @create_date: 24/03/2020
 */
public class BoxUtil {
	static final String topleft = "┌";
	static final String topright = "┐";
	static final String horizontal = "╌";
	static final String vertical = "╎";
	static final String botleft = "└";
	static final String botright = "┘";

	static int maxWidth(String[] input) {
		int max = 0;
		for (int index = 0; index < input.length; ++index) {
			if (input[index].length() > max) {
				max = input[index].length();
			}
		}
		return max;
	}

	public static void createBox(String[] input) {
		int max = maxWidth(input);
		
		// Đưa max về chẵn để ko bị sai phần menu
		if (max % 2 == 1) {
			max = max + 1;
		}

		// First line
		System.out.printf(topleft);
		// đảo dấu max
		System.out.printf(String.format("%" + -(max / 2 - 2) + "s", " ").replace(" ", horizontal));
		System.out.printf("MENU");
		System.out.printf(String.format("%" + -(max / 2 - 2) + "s", " ").replace(" ", horizontal));
		System.out.printf(topright + "\n");

		for (int index = 0; index < input.length; ++index) {
			System.out.printf(vertical);
			// đảo dấu max thì mới in từ đầu dòng, nếu ko nó sẽ in từ cuối dòng
			System.out.printf(String.format("%" + -max + "s", input[index]));
			System.out.printf(vertical + "\n");
		}

		// Last line
		System.out.printf(botleft);
		System.out.printf(String.format("%" + max + "s", " ").replace(" ", horizontal));
		System.out.printf(botright + "\n");
	}
}
