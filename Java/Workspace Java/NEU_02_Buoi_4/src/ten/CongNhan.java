package ten;

public class CongNhan extends Nguoi{
	private int cuoc;
	private int xeng;
	private int soGioLaoDong;

	public CongNhan(String name) {
		super(name);
	}

	
	public float tinhLuong() {
		return heSoLuong * 8;
	}

	public void xayNha() {
		System.out.println("Xay nha");
	}
	
	public void di() {
		System.out.println("di xe may");
	}

	

}
