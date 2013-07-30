package races;

import java.io.Serializable;

public class Dwarf extends Race implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8592078759572869114L;

	public Dwarf() { 
		super("Dwarf");
		super.setConBonus(2);
		super.setChaBonus(-2);
		super.setSize(4);
		super.setSpeed(20);
	}
}
