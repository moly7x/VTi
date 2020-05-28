package testWrapper;

public class Constructor {

	public static void main(String[] args) {
		long l = 1000;
		long a = new Long(l);
		
		String s = "2000";
		
		Long b = new Long(s);
		
		System.out.println(a);
	}

}
