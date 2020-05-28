//
package entity;

/**
 * This class is Drone extended from Bee. 
 * 
 * @author: Tân
 * @create_date: 24/03/2020
 */
public class Drone extends Bee{
	/**
	 * Constructor for class Drone. Set limit.
	 * 
	 * @author: Tân
	 * @create_date: 24/03/2020
	 */
	public Drone() {
		limit = 50;
	}
	
	@Override
	public String getType() {
		return "Drone";
	}
}
