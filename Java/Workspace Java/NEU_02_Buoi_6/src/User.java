import java.io.Serializable;

public class User implements Serializable{

	public User(int age) {
		this.age = age;
	}

	
	private transient int age;
	private int name;
	private int hocLuc;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
