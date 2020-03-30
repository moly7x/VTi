//
package com.vti.JavaFinalTest.frontend;

/**
 * This class is Exception.
 * 
 * @author: Tân
 * @create_date: 29/03/2020
 */
@SuppressWarnings("serial")
public class Errors extends Exception {

	// Code and messes
	static final int C1000 = 1000;
	static final String M1000 = "Error about Database. Can't connect or Query is false.";

	static final int C1001 = 1001;
	static final String M1001 = "Can't not find or open database properties file.";

	static final int C1002 = 1002;
	static final String M1002 = "Can't not find or open project properties file.";

	static final int C1003 = 1003;
	static final String M1003 = "Email isn't valid!! Please Input again.";

	static final int C1004 = 1004;
	static final String M1004 = "This email have been used. Please try another email.";

	static final int C1005 = 1005;
	static final String M1005 = "Phone number isn't valid!! Please Input again.\nOnly for Vietnamese number!!!(Phone Number has 10 digits)";

	static final int C1006 = 1006;
	static final String M1006 = "This phone number have been used. Please try another phone number.";

	static final int C1007 = 1007;
	static final String M1007 = "Exp In Year must be greater than 0 and smaller than 20.";

	static final int C1008 = 1008;
	static final String M1008 = "You must input number are allowed.";

	static final int C1009 = 1009;
	static final String M1009 = "This password is't valided!\n" + "1) Password must contain 6 -> 12 characters.\n"
			+ "2) Password must contain at least 1 number.\n"
			+ "3) Password must contain at least 1 upper case letter.\n"
			+ "4) Password must contain at least 1 lower case letter.\n"
			+ "5) Password must contain at least 1 special character.\n" + "Please Input Password again.";
	
	static final int C1010 = 1010;
	static final String M1010 = "Login is failed!! Wrong email or password!";
	
	int code;

	public Errors(int code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		switch (code) {
		case (C1000):
			return M1000;
		case (C1001):
			return M1001;
		case (C1002):
			return M1002;
		case (C1003):
			return M1003;
		case (C1004):
			return M1004;
		case (C1005):
			return M1005;
		case (C1006):
			return M1006;
		case (C1007):
			return M1007;
		case (C1008):
			return M1008;
		case (C1009):
			return M1009;
		case (C1010):
			return M1010;
		default:
			return "There was an unknown error";
		}
	}
}
