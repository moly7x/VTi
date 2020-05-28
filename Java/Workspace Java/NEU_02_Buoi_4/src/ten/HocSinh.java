package ten;

public class HocSinh extends Nguoi implements IThiBangLaiXe, INauAn {

	private float diemTrungBinh;
	private String theHocSinh;
	private boolean hasxeDap;

	public HocSinh(String name, boolean hasxeDap) {
		super(name);
		diemTrungBinh = 0;
		System.out.println("init hoc sinh");
		this.hasxeDap = hasxeDap;
	}

	public float getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(float diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}

	public float tinhLuong() {
		return 0;
	}

	public void hoc() {
		System.out.println("hoc");
	}

	@Override
	public void di() {
		if (hasxeDap) {
			System.out.println("di xe dap");
		} else {
			super.di();
		}
	}

	public float tinhDiemTrungBinh(float mon1, float mon2, float mon3, float mon4, float mon5, float mon6) {
		return (mon1 + mon2 + mon3 + mon4 + mon5 + mon6) / 6;
	}

	public float tinhDiemTrungBinh(float mon1, float mon2) {
		return (mon1 + mon2) / 3;
	}

	public float tinhDiemTrungBinh(float mon1, float mon2, float mon3) {
		return (mon1 + mon2 + mon3) / 3;
	}

	public float tinhDiemTrungBinh(int mon1, int mon2, int mon3) {
		return (mon1 + mon2 + mon3) / 3f;
	}

	@Override
	public int hocLyThuyet() {
		return 5;
	}

	@Override
	public void diThi() {
		System.out.println("thi 1 lan");

	}

	@Override
	public void nauCom() {
		// TODO Auto-generated method stub

	}

	@Override
	public void nauCanh() {
		// TODO Auto-generated method stub
		
	}
}
