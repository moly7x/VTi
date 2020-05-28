package assignment_5_2;

abstract class Employee {
	private String name, address;
	protected int basicSalary;

	public String getName() {
		return name;
	};

	public String getAddress() {
		return address;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setAddress(String add) {
		address = add;
	}

	public void setName(String nm) {
		name = nm;
	}

	public void setBasicSalary(int sal) {
		basicSalary = sal;
	}

	public abstract int getMonthlySalary();
}

class NormalEmployee extends Employee{

	@Override
	public int getMonthlySalary() {
		return getBasicSalary();
	}
	
}

public class BonusEmployee extends Employee{
	protected int bonus;

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public int getMonthlySalary() {
		return getBasicSalary()+bonus;
	}
	
}
