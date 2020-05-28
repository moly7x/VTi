//
package com.vti.jdbc.entity;

/**
 * This class is .
 * 
 * @Description: .
 * @author: hung34atp
 * @create_date: Mar 23, 2020
 * @version: 1.0
 * @modifer: hung34atp
 * @modifer_date: Mar 23, 2020
 */
public class Trainee {
	private int id;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;

	/**
	 * Constructor for class Trainee.
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 23, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 23, 2020
	 */
	public Trainee() {
		super();
	}

	/**
	 * Constructor for class Trainee.
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 23, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 23, 2020
	 * @param account
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Trainee(int id, String userName, String passWord, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;

	}
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
