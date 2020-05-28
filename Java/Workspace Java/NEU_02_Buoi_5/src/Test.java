import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
//		try {
//			System.out.println("Ket Noi Toi Database");
//			System.out.println("Dang Lay Du Lieu ...");
//			// HocSinh hs = initHocSinh();
//			// System.out.println(hs.getDiemTrungBinh());
//			int a = 1;
//			int b = 0;
//			// System.out.println(a / b);
//			System.out.println("Lay Du Lieu Thanh Cong");
//
//		} catch (NullPointerException e) {
//			System.out.println("doi tuong chua khoi tao");
//		} catch (ArithmeticException e) {
//			System.out.println("Loi Toan Hoc");
//		} catch (Exception e) {
//			System.out.println("Khong biet loi gi");
//		} finally {
//			System.out.println("Dong Ket Noi Database");
//		}
//
//		System.out.println("continue program");

//		int a = 1;
//		int b = 0;
// 		System.out.println(a / b);

//		String[] arrays = { "a", "b" };
//
//		for (int i = 0; i < 5; i++) {
//			System.out.println(arrays[i]);
//		}

//		float result = divide(5, 0);
//		System.out.println(result);

//		Customer customer = new Customer("quan", true);
//
//		try {
//			checkThanhToan(customer);
//			System.out.println("di ra cua hang");
//		} catch (NotPayException e) {
//			System.out.println("phat hien ra: " + e.getMessage());
//			System.out.println("Goi bao ve");
//		}

		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println(a);

	}

	private static void checkThanhToan(Customer customer) throws NotPayException {
		if (!customer.isPay()) {
			throw new NotPayException("Thang nay chua thanh toan dau");
		}
	}

	private static float divide(int a, int b) throws ArithmeticException {
		float result = temp(a, b);
		return result;
	}

	private static float temp(int a, int b) {
		return (float) (a / b);
	}

}
