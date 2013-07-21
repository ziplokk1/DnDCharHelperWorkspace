package races;

public class Elf extends Race {
	public Elf() { 
		super("Elf");
		super.setDexBonus(2);
		super.setConBonus(-2);
		super.setSize(4);
		super.setSpeed(30);
	}
}
