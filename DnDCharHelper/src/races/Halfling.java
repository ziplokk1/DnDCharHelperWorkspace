package races;

import java.io.Serializable;

public class Halfling extends Race implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8456069985171010843L;

	public Halfling() { 
		super("Halfling");
		setDexBonus(2);
		setStrBonus(-2);
		setSize(3);
		setSpeed(20);
	}
}
