package ten;

public class GiaoVien extends Nguoi implements IThiBangLaiXe {
	private int phan;
	private int bang;
	private int soGioDay;

	public GiaoVien(String name) {
		super(name);
	}

	public float tinhLuong() {
		return heSoLuong * 6;
	}

	public void dayHoc() {
		System.out.println("day hoc");
	}

	public void di() {
		System.out.println("di xe may");
	}

	@Override
	public int hocLyThuyet() {
		return 10;
	}

	@Override
	public void diThi() {
		System.out.println("thi 2 lan");

	}
	
}
