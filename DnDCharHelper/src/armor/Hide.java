package armor;

import res.Money.Gold;

public class Hide extends Armor {
	public Hide() { 
		super("Hide");
		setCost(new Gold(15));
		setArmorBonus(3);
		setMaxDexBonus(4);
		setArmorCheckPenalty(-3);
		setArcaneSpellFailure(0.2D);
		setSpeed(20);
		setWeight(25);
	}
}
