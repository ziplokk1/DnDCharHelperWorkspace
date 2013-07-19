package armor;

import res.Money.Gold;

public class Padded extends Armor {
	public Padded() { 
		super("Padded");
		setCost(new Gold(5));
		setArmorBonus(1);
		setMaxDexBonus(8);
		setArmorCheckPenalty(0);
		setArcaneSpellFailure(0.05D);
		setSpeed(30);
		setWeight(10);
	}
}
