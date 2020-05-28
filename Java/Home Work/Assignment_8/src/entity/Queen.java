//
package entity;

/**
 * This class is Queen extended from Bee. 
 * 
 * @author: Tân
 * @create_date: 24/03/2020
 */
public class Queen extends Bee{
	/**
	 * Constructor for class Queen. Set limit.
	 * 
	 * @author: Tân
	 * @create_date: 24/03/2020
	 */
	public Queen() {
		limit = 20;
	}
	
	@Override
	public String getType() {
		return "Queen";
	}
}
