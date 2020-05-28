//
package businesslayer;

import java.util.List;

import datalayer.StudentDAO;
import entity.Student;

/**
 * This class is User service.
 * 
 * @author: Tân
 * @create_date: 03/05/2020
 */
public class UserService {
	public static void main(String[] args) {
		List<Student> students = StudentDAO.searchStudent("hanoi");
		
		System.out.println(students.isEmpty());
		
		for (int index = 0; index < students.size(); ++index) {
			System.out.println(students.get(index).getName() + " " + students.get(index).getAge() + " "
					+ students.get(index).getGender() + " " + students.get(index).getSchool() + " "
					+ students.get(index).getPhoneNumber() + " " + students.get(index).getAddress() + " ");
		}
	}
}
