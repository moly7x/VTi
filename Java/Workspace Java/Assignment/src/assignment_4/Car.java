package assignment_4;

public class Car {
	private int speed;
	private double regularPrice;
	String color;
	
	Car (int speed, double regularPrice){
		this.speed = speed;
		this.regularPrice = regularPrice;
	}
	
	double getSalePrice() {
		return regularPrice;
	};
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
