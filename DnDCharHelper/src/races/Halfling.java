package races;

public class Halfling extends Race {
	public Halfling() { 
		super("Halfling");
		setDexBonus(2);
		setStrBonus(-2);
		setSize(3);
		setSpeed(20);
	}
}
