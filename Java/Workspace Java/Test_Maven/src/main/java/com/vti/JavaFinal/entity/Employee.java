//
package com.vti.JavaFinal.entity;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class Employee extends User {
	int projectName;
	String proSkill;
	
	/**
	 * 
	 * Constructor for class Employee.
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 * @param firstname
	 * @param lastname
	 * @param phone
	 * @param email
	 * @param projectname
	 * @param proSkill
	 */
	public Employee(String firstname, String lastname, String phone, String email, int projectname, String proSkill) {
		setFirstname(firstname);
		setLastname(lastname);
		setPhone(phone);
		setEmail(email);
		setProjectName(projectname);
		setProSkill(proSkill);
	}

	public int getProjectName() {
		return projectName;
	}

	public void setProjectName(int projectName) {
		this.projectName = projectName;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

}
