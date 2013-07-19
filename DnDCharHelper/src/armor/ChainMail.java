package armor;

import res.Money.Gold;

public class ChainMail extends Armor {
	public ChainMail() { 
		super("Chain Mail");
		setCost(new Gold(150));
		setArmorBonus(5);
		setMaxDexBonus(2);
		setArmorCheckPenalty(-5);
		setArcaneSpellFailure(0.3D);
		setSpeed(20);
		setWeight(40);
	}
}
