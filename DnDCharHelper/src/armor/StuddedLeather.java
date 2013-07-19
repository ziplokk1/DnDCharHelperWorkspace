package armor;

import res.Money.Gold;

public class StuddedLeather extends Armor {
	public StuddedLeather() { 
		super("Studded Leather");
		setCost(new Gold(25));
		setArmorBonus(3);
		setMaxDexBonus(5);
		setArmorCheckPenalty(-1);
		setArcaneSpellFailure(0.15D);
		setSpeed(30);
		setWeight(20);
	}
}
