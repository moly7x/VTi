package ScannerUtils;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// demo ScannerUntil
		Scanner scanner = new Scanner(System.in);

		System.out.print("moi nhap vao 1 so float: ");
		float resultInt = ScannerUtil.readFloat(scanner, Constant.ERROR_VALIDATE_INT);
		System.out.println("result: " + resultInt);

		System.out.print("moi nhap vao 1 String: ");
		String resultStr = ScannerUtil.readString(scanner, Constant.ERROR_VALIDATE_STRING);
		System.out.println("result: " + resultStr);
	}
}
