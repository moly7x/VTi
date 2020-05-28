package assignment_4;

public class Ford extends Car{
	private int year;
	private int manuafactureDiscount;
	
	Ford(int speed, double regularPrice, int year, int manuafactureDiscount){
		super(speed, regularPrice);
		this.year = year;
		this.manuafactureDiscount = manuafactureDiscount;
	}
	
	@Override
	double getSalePrice() {
		return getRegularPrice() - manuafactureDiscount;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getManuafactureDiscount() {
		return manuafactureDiscount;
	}

	public void setManuafactureDiscount(int manuafactureDiscount) {
		this.manuafactureDiscount = manuafactureDiscount;
	}
	
	
	
}
