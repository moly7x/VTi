//
package com.vti.JavaFinal.entity;

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
	 * @param phone
	 * @param email
	 * @param ExpInYear
	 */
	public Manager(String firstname, String lastname, String phone, String email, int expInYear) {
		setFirstname(firstname);
		setLastname(lastname);
		setPhone(phone);
		setEmail(email);
		setExpInYear(expInYear);
	}
	
	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}
}
