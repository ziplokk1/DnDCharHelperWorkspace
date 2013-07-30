package races;

import java.io.Serializable;

public class Elf extends Race implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5776954355309237856L;

	public Elf() { 
		super("Elf");
		super.setDexBonus(2);
		super.setConBonus(-2);
		super.setSize(4);
		super.setSpeed(30);
	}
}
