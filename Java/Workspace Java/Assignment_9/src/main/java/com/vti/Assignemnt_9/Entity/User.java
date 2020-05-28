//
package com.vti.Assignemnt_9.Entity;

/**
 * This class is User.
 * 
 * @author: Tân
 * @create_date: 31/03/2020
 */
public class User {
	String account;
	String first_name;
	String last_name;
	String email;

	public User(String account, String first_name, String last_name, String email) {
		setAccount(account);
		setFirst_name(first_name);
		setLast_name(last_name);
		setEmail(email);
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;

	}

}
