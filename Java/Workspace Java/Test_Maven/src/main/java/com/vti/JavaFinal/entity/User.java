//
package com.vti.JavaFinal.entity;

import java.util.regex.Pattern;

/**
 * This class is user.
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public abstract class User {
	private String firstname;
	private String lastname;
	private String phone;
	private String email;

	public static boolean checkPhone(String phone) {
		if (9 <= phone.length() && phone.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkEmail(String email) {
		String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		if (Pattern.matches(regex, email)) {
			return true;
		} else {
			return false;
		}
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method is . 
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 * @param pass
	 * @return
	 */
	public static boolean checkPass(String pass) {
		if (pass == "") { return false;};
		return true;
	}

}
