package res.Money;

import java.io.Serializable;


public class Copper extends Currency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6424098394671268473L;

	public Copper(int amount) {
		super(amount);
	}
	
	public Copper() { 
		super(0);
	}
}
