//
package datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseUtils;

import entity.Student;

/**
 * This class is access to Database of student.
 * 
 * @author: Tân
 * @create_date: 03/05/2020
 */
public class StudentDAO {
	/**
	 * 
	 * This method is .
	 * 
	 * @author: Tân
	 * @create_date: 03/05/2020
	 * @return
	 */
	public static List<Student> getAll() {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		List<Student> students = new ArrayList<Student>();
		try {
			// Connect to database
			Class.forName("com.mysql.jdbc.Driver");
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement("SELECT * FROM STUDENT;");

			// Execute Query
			result = query.executeQuery();

			while (result.next()) {
				students.add(new Student());
				students.get(students.size() - 1).setName(result.getString("name"));
				students.get(students.size() - 1).setAge(result.getByte("age"));
				students.get(students.size() - 1).setGender(result.getString("gender"));
				students.get(students.size() - 1).setSchool(result.getString("school"));
				students.get(students.size() - 1).setPhoneNumber(result.getString("phonenumber"));
				students.get(students.size() - 1).setAddress(result.getString("address"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
		return students;
	}

	/**
	 * 
	 * This method is searching student's information.
	 * 
	 * @author: Tân
	 * @create_date: 09/05/2020
	 * @param search
	 * @return
	 */
	public static List<Student> searchStudent(String search) {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		List<Student> students = new ArrayList<Student>();

		if (search.isBlank()) {
			return students;
		}

		search = "%" + search + "%";
		try {
			// Connect to database
			Class.forName("com.mysql.jdbc.Driver");
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"SELECT * FROM STUDENT WHERE `NAME` LIKE ? OR `AGE` LIKE ? OR `GENDER` LIKE ? OR `SCHOOL` LIKE ? OR `PHONENUMBER` LIKE ? OR `ADDRESS` LIKE ?;");

			// Set parameter
			query.setString(1, search);
			query.setString(2, search);
			query.setString(3, search);
			query.setString(4, search);
			query.setString(5, search);
			query.setString(6, search);

			// Execute Query
			result = query.executeQuery();

			while (result.next()) {
				students.add(new Student());
				students.get(students.size() - 1).setName(result.getString("name"));
				students.get(students.size() - 1).setAge(result.getByte("age"));
				students.get(students.size() - 1).setGender(result.getString("gender"));
				students.get(students.size() - 1).setSchool(result.getString("school"));
				students.get(students.size() - 1).setPhoneNumber(result.getString("phonenumber"));
				students.get(students.size() - 1).setAddress(result.getString("address"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
		return students;
	}

	/**
	 * 
	 * This method is creating Students.
	 * 
	 * @author: Tân
	 * @create_date: 09/05/2020
	 * @param search
	 * @return
	 */
	public static List<Student> createStudent(String name, String Sage, String gender, String school, String phoneNumber,
			String address) {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		List<Student> students = new ArrayList<Student>();
		
		// convert String age to int age		
		int age=Integer.parseInt(Sage);  
		
		try {
			// Connect to database
			Class.forName("com.mysql.jdbc.Driver");
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"INSERT INTO STUDENT(`NAME`, AGE, GENDER, SCHOOL, PHONENUMBER, ADDRESS) VALUES (?, ?, ?, ?, ?, ?);");

			// Set parameter
			query.setString(1, name);
			query.setInt(2, age);
			query.setString(3, gender);
			query.setString(4, school);
			query.setString(5, phoneNumber);
			query.setString(6, address);

			// Execute Query
			query.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
		return students;
	}
}