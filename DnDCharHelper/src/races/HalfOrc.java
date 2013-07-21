package races;

public class HalfOrc extends Race {
	public HalfOrc() { 
		super("Half-Orc");
		super.setStrBonus(2);
		super.setIntBonus(-2);
		super.setChaBonus(-2);
		super.setSize(4);
		super.setSpeed(30);
	}
}
