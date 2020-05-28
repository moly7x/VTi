package ten;
import java.util.ArrayList;
import java.util.List;

public class MainProgram {
	public static void main(String[] args) {

		List<Nguoi> nguois = new ArrayList<>();
		nguois.add(new HocSinh("Nguyen Van HS1", true));
		nguois.add(new HocSinh("Nguyen Van HS2", false));
		nguois.add(new HocSinh("Nguyen Van HS3", false));
		nguois.add(new HocSinh("Nguyen Van HS4", true));

		nguois.add(new Developer("Tran Thi D1"));
		nguois.add(new Developer("Tran Thi D2"));
		nguois.add(new Developer("Tran Thi D3"));
		nguois.add(new Developer("Tran Thi D4"));

		nguois.add(new GiaoVien("Tran Thi GV1"));
		nguois.add(new GiaoVien("Tran Thi GV2"));

		for (int i = 0; i < nguois.size(); i++) {
			System.out.println(nguois.get(i).getName() + " " + nguois.get(i).tinhLuong());

			nguois.get(i).di();

			// neu ma la hoc sinh
			if (nguois.get(i) instanceof HocSinh) {
				HocSinh hs = (HocSinh) nguois.get(i);
				hs.hoc();
				hs.tinhDiemTrungBinh(4.0f, 6.5f, 7.3f, 8, 9, 10);
			} else if (nguois.get(i) instanceof Developer) {
				((Developer) nguois.get(i)).lapTrinh();
			}
		}

		System.out.println("----------------------------------------------");

		List<IThiBangLaiXe> thiBangLaiXes = new ArrayList<>();
		thiBangLaiXes.add(new HocSinh("Nguyen Van HS1", true));
		thiBangLaiXes.add(new GiaoVien("Tran Thi GV1"));
		thiBangLaiXes.add(new HocSinh("Nguyen Van HS2", true));

		for (int i = 0; i < thiBangLaiXes.size(); i++) {
			System.out.println("Hoc Ly Thuyet Trong Vong ? ngay: " + thiBangLaiXes.get(i).hocLyThuyet());

			if (thiBangLaiXes.get(i) instanceof HocSinh) {
				// uu dai hoc phi
			}
		}

	}
}
