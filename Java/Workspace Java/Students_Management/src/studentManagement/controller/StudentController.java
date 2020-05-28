package studentManagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManagement.entity.Student;
import studentManagement.model.StudentDAO;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getRequestURI();
		switch (action.substring(32)) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertStudent(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateStudent(request, response);
			break;
		case "/delete":
			deleteStudent(request, response);
			break;
		default:
			listStudent(request, response);
			break;
		}
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> listStudents = StudentDAO.getAll();
		request.setAttribute("listStudents", listStudents);
		RequestDispatcher dispathcer = request.getRequestDispatcher("/views/list.jsp");
		dispathcer.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispathcer = request.getRequestDispatcher("/views/studentForm.jsp");
		dispathcer.forward(request, response);
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		byte age = Byte.parseByte(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String school = request.getParameter("school");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		Student student = new Student(name, age, gender, school, phoneNumber, address);
		StudentDAO.createStudent(student);
		response.sendRedirect("");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		byte id = Byte.parseByte(request.getParameter("id"));
		Student student = StudentDAO.searchStudent(id);
		request.setAttribute("listStudents", student);
		RequestDispatcher dispathcer = request.getRequestDispatcher("/views/studentForm.jsp");
		dispathcer.forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		byte age = Byte.parseByte(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String school = request.getParameter("school");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		Student student = new Student(id, name, age, gender, school, phoneNumber, address);
		StudentDAO.updateStudent(student);
		response.sendRedirect("");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = new Student(id);
		StudentDAO.deleteStudent(student);
		response.sendRedirect("");
	}
}
