package testWrapper;

public class PrimitivAndObject {

	public static void main(String[] args) {
		int x = 100;
		Integer y = Integer.valueOf(x);
		
		int z = y.intValue();
		System.out.println(z);
		
		
		byte a = 70;
		String b = Byte.toString(a);
		
		byte c = Byte.parseByte(b);
		System.out.println(c);
		
		
		long j = 1000;
		Long q = Long.valueOf(j);
		String s = q.toString();
		
		Long k = Long.valueOf(s);
		System.out.println(k);
	}

}
