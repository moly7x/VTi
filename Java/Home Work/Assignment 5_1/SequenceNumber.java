package assignment_4_1;

import java.util.Scanner;

public class SequenceNumber {
	static int n;
	static int[] arr;
	
	public SequenceNumber(int n) {
		SequenceNumber.n = n;
		arr = new int[n];
		for (int i = 0; i < n; ++i) {
			System.out.print("arr[" + i + "]= ");
			arr[i] = input(i);
		}
	}

	public SequenceNumber() {
	}

	@SuppressWarnings("resource")
	static int input(int key) {
		do {
			try {
				return Integer.parseInt(new Scanner(System.in).next());
			} catch (NumberFormatException ne) {
				System.out.println("Input must be integer");
				if (key == -1) {
					System.out.print("N= ");
				} else {
					System.out.print("arr[" + key + "]= ");
				}
			}
		} while (true);
	}

	void print() {
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
