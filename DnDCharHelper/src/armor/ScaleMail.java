package armor;

import res.Money.Gold;

public class ScaleMail extends Armor {
	public ScaleMail() { 
		super("Scale Mail");
		setCost(new Gold(50));
		setArmorBonus(4);
		setMaxDexBonus(3);
		setArmorCheckPenalty(-4);
		setArcaneSpellFailure(0.25D);
		setSpeed(20);
		setWeight(30);
	}
}
