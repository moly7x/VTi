package entity;

public class Professor extends Employee implements Comparable<Professor> {
	private String faculty;
	private int academic_degree;
	private float monthly_teaching_time;

	public Professor(String fullname, String faculty, int academic_degree, int allowance, float monthly_teaching_time,
			float salary_multiplier, float salary) {
		setFullname(fullname);
		setFaculty(faculty);
		setAcademic_degree(academic_degree);
		setAllowance(allowance);
		setMonthly_teaching_time(monthly_teaching_time);
		setSalary_multiplier(salary_multiplier);
		setSalary(salary);
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getAcademic_degree() {
		return academic_degree;
	}

	String get_Word(int input) {
		switch (input) {
		case 1:
			return "Bachelor";
		case 2:
			return "Master";
		default:
			return "Doctor";
		}
	}

	public void setAcademic_degree(int academic_degree) {
		this.academic_degree = academic_degree;
	}

	public float getMonthly_teaching_time() {
		return monthly_teaching_time;
	}

	public void setMonthly_teaching_time(float monthly_teaching_time) {
		this.monthly_teaching_time = monthly_teaching_time;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-20s%-20s%-14d%-26.2f%-22.2f%.2f", this.getFullname(), this.getFaculty(),
				get_Word(this.getAcademic_degree()), this.getAllowance(), this.getMonthly_teaching_time(),
				this.getSalary_multiplier(), this.getSalary());
	}

	@Override
	public int compareTo(Professor p) {
		return this.getFullname().compareTo(p.getFullname());
	}
}