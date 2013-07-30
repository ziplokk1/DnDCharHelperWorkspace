package races;

import java.io.Serializable;

public class HalfOrc extends Race implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7867480442290595017L;

	public HalfOrc() { 
		super("Half-Orc");
		super.setStrBonus(2);
		super.setIntBonus(-2);
		super.setChaBonus(-2);
		super.setSize(4);
		super.setSpeed(30);
	}
}
