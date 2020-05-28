package entity;

/**
 * This class is Bee.
 * 
 * @author: Tân
 * @create_date: 24/03/2020
 */
public abstract class Bee {
	int limit;
	int health;

	/**
	 * Constructor for class Bee. Set health
	 * 
	 * @author: Tân
	 * @create_date: 24/03/2020
	 */
	public Bee() {
		health = 100;
	}

	public void Damage(int dam) {
		if (health >= limit) {
			if (health >= dam) {
				health = health - dam;
			} else {
				health = 0;
			}
		}
	}

	public String checkHeathStatus() {
		if (health >= limit) {
			return "Alive";
		} else {
			return "Dead";
		}
	}

	public abstract String getType();

	public String toString(int index) {
		return String.format("%-11d%-9s%-10s%-11s%-11s", index + 1, getType(), limit, health, checkHeathStatus());
	}
}
