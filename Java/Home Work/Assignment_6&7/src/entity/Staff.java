package entity;

public class Staff extends Employee implements Comparable<Staff>{
	private String department;
	private float working_time;
	private int position;

	public Staff(String fullname, String department, float working_time, float salary_multiplier, int position,
			int allowance, float salary) {
		setFullname(fullname);
		setDepartment(department);
		setWorking_time(working_time);
		setSalary_multiplier(salary_multiplier);
		setPosition(position);
		setAllowance(allowance);
		setSalary(salary);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getWorking_time() {
		return working_time;
	}

	public void setWorking_time(float working_time) {
		this.working_time = working_time;
	}

	public int getPosition() {
		return position;
	}
	
	String get_Word(int input) {
		switch (input) {
		case 1:
			return "Department head";
		case 2:
			return "Vice head ";
		default:
			return "Staff";
		}
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-20s%-17.2f%-22.2f%-13s%-14d%.2f", this.getFullname(), this.getDepartment(),
				this.getWorking_time(), this.getSalary_multiplier(), get_Word(this.getPosition()), this.getAllowance(),
				this.getSalary());
	}
	
	@Override
    public int compareTo(Staff s) {
        return this.getFullname().compareTo(s.getFullname());
    }

}
