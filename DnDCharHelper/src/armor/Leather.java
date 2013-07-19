package armor;

import res.Money.Gold;

public class Leather extends Armor {
	public Leather() { 
		super("Leather");
		setCost(new Gold(10));
		setArmorBonus(2);
		setMaxDexBonus(6);
		setArmorCheckPenalty(0);
		setArcaneSpellFailure(0.1D);
		setSpeed(30);
		setWeight(15);
	}
}
