public class MainProgram {

	public static void main(String[] args) {
		String ten1 = "a";
		System.out.println(ten1.hashCode());

		ten1 += "b";
		System.out.println(ten1.hashCode());

		System.out.println("ab".hashCode());

		System.out.println("ab"== ten1);
		System.out.println("ab".equals(ten1));

//		User user1 = new User(5);
//		User user2 = user1;
//		user1.setAge(3);
//		System.out.println(user1.getAge());
//		System.out.println(user2.getAge());
//
//		System.out.println(user1.equals(user2));
	}

}
