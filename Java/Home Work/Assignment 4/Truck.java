package assignment_4;

public class Truck extends Car {
	private int weight;
	
	Truck(int speed, double regularPrice, int weight){
		super(speed, regularPrice);
		this.weight = weight;
	}
	
	@Override
	double getSalePrice() {
		if (weight > 2000) {
			return getRegularPrice()-(getRegularPrice()*0.1d);
		} else {
			return getRegularPrice()-(getRegularPrice()*0.2d);
		}
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
