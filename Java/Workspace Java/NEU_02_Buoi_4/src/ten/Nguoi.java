package ten;

public abstract class Nguoi {
	private byte soLuongMat;
	private String mauMat;
	protected String kieuMui;
	protected float tien;
	protected byte tay;
	protected float heSoLuong;
	private String name;

	public Nguoi(String name) {
		this.name = name;
		heSoLuong = 1;
	}

	public String getName() {
		return name;
	}

	public abstract float tinhLuong();

	public void di() {
		System.out.println("di xe dap");
	}

	public void an() {
		System.out.println("an");
	}
}
