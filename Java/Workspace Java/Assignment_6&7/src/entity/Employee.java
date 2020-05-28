package entity;

public abstract class Employee {
	private String fullname;
	private int allowance;
	private float salary_multiplier;
	private float salary;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public float getSalary_multiplier() {
		return salary_multiplier;
	}

	public void setSalary_multiplier(float salary_multiplier) {
		this.salary_multiplier = salary_multiplier;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}