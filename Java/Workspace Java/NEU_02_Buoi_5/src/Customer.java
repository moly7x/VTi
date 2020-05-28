import java.util.Date;

public class Customer {
	private String item;
	private boolean isPay;
	private HocSinh hocSinh;
	
	public Customer(String item, boolean isPay) {
		this.item = item;
		this.isPay = isPay;
		hocSinh = new HocSinh();
		hocSinh = null;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the isPay
	 */
	public boolean isPay() {
		return isPay;
	}

	/**
	 * @param isPay the isPay to set
	 */
	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

}
