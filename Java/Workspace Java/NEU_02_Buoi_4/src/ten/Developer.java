package ten;

public class Developer extends Nguoi {

	private String laptop;
	private String phanMem;

	public Developer(String name) {
		super(name);
	}

	public void lapTrinh() {
		System.out.println("lapTrinh");
	}

	@Override
	public float tinhLuong() {
		return 15;
	}

	public void di() {
		System.out.println("di oto");
	}

}
