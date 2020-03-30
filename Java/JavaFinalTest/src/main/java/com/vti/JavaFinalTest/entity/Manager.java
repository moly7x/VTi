//
package com.vti.JavaFinalTest.entity;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class Manager extends User{
	int ExpInYear;
	
	/**
	 * 
	 * Constructor for class Manager.
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param phone
	 * @param password
	 * @param role
	 * @param ExpInYear
	 */
	public Manager(String firstname, String lastname, String email, String phone, String password, int role, int expInYear) {
		setFirstname(firstname);
		setLastname(lastname);
		setEmail(email);
		setPhone(phone);
		setPassword(password);
		setRole(role);
		setExpInYear(expInYear);
	}
	
	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}
}
