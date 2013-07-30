package races;

import java.io.Serializable;

public class Human extends Race implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1011299329006673848L;

	public Human() { 
		super("Human");
		setSize(4);
		setSpeed(30);
	}
}
