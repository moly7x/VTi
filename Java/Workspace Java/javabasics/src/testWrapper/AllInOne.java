package testWrapper;

class Data {

	int data1;
	int data2;
}

class NewData extends Data {

	int data3;
	int data4;
}

public class AllInOne {

	public static void main(String[] args) {
		
		Data obj1 = new Data();
		obj1.data1 = 50;
		obj1.data2 = 100;
		Data obj2 = obj1;
		obj2 = (NewData) obj2;
		obj2.data3 = 100;
		System.out.println("obj.data1 = " + obj1.data1);
		System.out.println("obj.data2 = " + obj1.data2);
		System.out.println();
		System.out.println("obj.data1 = " + obj2.data1);
		System.out.println("obj.data2 = " + obj2.data2);
		System.out.println("obj.data2 = " + obj2.data3);
	}
}
