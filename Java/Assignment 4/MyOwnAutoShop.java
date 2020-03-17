package assignment_4;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		Sedan sedan1 = new Sedan(100, 50000d, 21);
		
		Ford ford1 = new Ford(150, 150000d, 2018, 2730);
		Ford ford2 = new Ford(170, 170000d, 2019, 2010);
		
		Car car1 = new Car(75, 42570);
		
		System.out.println(sedan1.getSalePrice());
		System.out.println(ford1.getSalePrice());
		System.out.println(ford2.getSalePrice());
		System.out.println(car1.getSalePrice());
	}

}
