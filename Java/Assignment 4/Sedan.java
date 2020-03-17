package assignment_4;

public class Sedan extends Car {
	private int length;
	
	Sedan(int speed, double regularPrice, int length){
		super(speed, regularPrice);
		this.length = length;
	}

	@Override
	double getSalePrice() {
		if (length > 20) {
			return getRegularPrice()-(getRegularPrice()*0.05d);
		} else {
			return getRegularPrice()-(getRegularPrice()*0.1d);
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	
}
