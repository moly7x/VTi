package com.vti.JavaFinal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static void main(String[] args) {
		String kitu = "hello world";
		String[] ct = kitu.split("[ ,.]");
		int count = ct.length;
		for (int i = 0; i < ct.length; ++i) {
			if (ct[i].equals("")) {
				count--;
			}
		}
		System.out.println(ct);
	}
}
