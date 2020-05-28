//
package com.vti.JavaFinalTest.entity;

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
	private String password;
	private int role;

	public static boolean checkPhone(String phone) {
		if (9 <= phone.length() && phone.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkPass(String pass) {
		if (pass == "") {
			return false;
		}
		;
		return true;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;

	}

}
