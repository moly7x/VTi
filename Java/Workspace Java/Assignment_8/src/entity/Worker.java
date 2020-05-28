//
package entity;

/**
 * This class is Worker extended from bee. 
 * 
 * @author: Tân
 * @create_date: 24/03/2020
 */
public class Worker extends Bee{
	/**
	 * Constructor for class Worker. Set limit.
	 * 
	 * @author: Tân
	 * @create_date: 24/03/2020
	 */
	public Worker() {
		limit = 70;
	}
	
	/* 
	* @see entity.Bee#getType()
	*/
	@Override
	public String getType() {
		return "Worker";
	}
}
