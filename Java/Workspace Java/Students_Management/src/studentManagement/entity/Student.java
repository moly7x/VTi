//
package studentManagement.entity;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 03/05/2020
 */
public class Student {
	private int ID;
	private String name;
	private byte age;
	private String gender;
	private String school;
	private String phoneNumber;
	private String address;

	public Student() {

	}

	public Student(int ID) {
		this.ID = ID;
	}

	public Student(String name, byte age, String gender, String school, String phoneNumber, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.school = school;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Student(int ID, String name, byte age, String gender, String school, String phoneNumber, String address) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.school = school;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
