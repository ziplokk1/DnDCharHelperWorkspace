package races;

import java.io.Serializable;

public class Gnome extends Race implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3448899993730699962L;

	public Gnome() { 
		super("Gnome");
		super.setConBonus(2);
		super.setStrBonus(-2);
		super.setSize(3);
		super.setSpeed(20);
	}
}
