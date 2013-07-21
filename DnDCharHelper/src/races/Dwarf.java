package races;

public class Dwarf extends Race {
	
	public Dwarf() { 
		super("Dwarf");
		super.setConBonus(2);
		super.setChaBonus(-2);
		super.setSize(4);
		super.setSpeed(20);
	}
}
