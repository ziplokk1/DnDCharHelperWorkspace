package races;

import java.io.Serializable;

public class HalfElf extends Race implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3987414847689605100L;

	public HalfElf() { 
		super("Half-Elf");
		super.setSize(4);
		super.setSpeed(30);
	}
}
