//
package studentManagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentManagement.entity.Student;
import studentManagement.utils.DatabaseUtils;

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
				students.get(students.size() - 1).setID(result.getInt("id"));
				students.get(students.size() - 1).setName(result.getString("name"));
				students.get(students.size() - 1).setAge(result.getByte("age"));
				students.get(students.size() - 1).setGender(result.getString("gender"));
				students.get(students.size() - 1).setSchool(result.getString("school"));
				students.get(students.size() - 1).setPhoneNumber(result.getString("phonenumber"));
				students.get(students.size() - 1).setAddress(result.getString("address"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
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
	public static Student searchStudent(byte id) {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;
		
		Student students = new Student();
		try {
			// Connect to database
			Class.forName("com.mysql.jdbc.Driver");
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"SELECT * FROM STUDENT WHERE ID=?;");

			// Set parameter
			query.setByte(1, id);

			// Execute Query
			result = query.executeQuery();

			while (result.next()) {
				students.setID(result.getInt("id"));
				students.setName(result.getString("name"));
				students.setAge(result.getByte("age"));
				students.setGender(result.getString("gender"));
				students.setSchool(result.getString("school"));
				students.setPhoneNumber(result.getString("phonenumber"));
				students.setAddress(result.getString("address"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
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
	public static void createStudent(Student student) {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			Class.forName("com.mysql.jdbc.Driver");
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"INSERT INTO STUDENT(`NAME`, AGE, GENDER, SCHOOL, PHONENUMBER, ADDRESS) VALUES (?, ?, ?, ?, ?, ?);");

			// Set parameter
			query.setString(1, student.getName());
			query.setByte(2, student.getAge());
			query.setString(3, student.getGender());
			query.setString(4, student.getSchool());
			query.setString(5, student.getPhoneNumber());
			query.setString(6, student.getAddress());

			// Execute Query
			query.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}

	/**
	 * 
	 * This method is update Students.
	 * 
	 * @author: Tân
	 * @create_date: 09/05/2020
	 * @param search
	 * @return
	 */
	public static void updateStudent(Student student) {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			Class.forName("com.mysql.jdbc.Driver");
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"UPDATE STUDENT SET `NAME`=?, AGE=?, GENDER=?, SCHOOL=?, PHONENUMBER=?, ADDRESS=? WHERE ID=?;");

			// Set parameter
			query.setString(1, student.getName());
			query.setByte(2, student.getAge());
			query.setString(3, student.getGender());
			query.setString(4, student.getSchool());
			query.setString(5, student.getPhoneNumber());
			query.setString(6, student.getAddress());
			query.setInt(7, student.getID());

			// Execute Query
			query.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}

	/**
	 * 
	 * This method is update Students.
	 * 
	 * @author: Tân
	 * @create_date: 09/05/2020
	 * @param search
	 * @return
	 */
	public static void deleteStudent(Student student) {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			// Connect to database
			Class.forName("com.mysql.jdbc.Driver");
			connect = DatabaseUtils.connect();

			query = connect.prepareStatement(
					"DELETE FROM STUDENT WHERE ID=?;");

			// Set parameter
			query.setInt(1, student.getID());

			// Execute Query
			query.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Close query, result, connection
			DatabaseUtils.closeAll(connect, query, result);
		}
	}
}