//
package com.vti.Assignemnt_9.frontend;

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
	static final String M1004 = "Email or Account is not valid. Please input another Email or Account";
	
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
		default:
			return "There was an unknown error";
		}
	}
}
