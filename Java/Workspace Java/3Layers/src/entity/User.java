package entity;

/**
 * This class is user .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 20, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 20, 2020
 */
public class User {
	private String ten;
	private int tuoi;

	/**
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 20, 2020
	 * @param ten
	 * @param tuoi
	 */
	public User(String ten, int tuoi) {
		this.ten = ten;
		this.tuoi = tuoi;
	}

	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}

	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}

	/**
	 * @return the tuoi
	 */
	public int getTuoi() {
		return tuoi;
	}

	/**
	 * @param tuoi the tuoi to set
	 */
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

}
