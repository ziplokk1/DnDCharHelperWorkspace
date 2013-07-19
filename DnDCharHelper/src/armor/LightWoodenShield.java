package armor;

import res.Money.Gold;

public class LightWoodenShield extends Armor {
	public LightWoodenShield() {
		super("Shield, Light Wooden");
		setCost(new Gold(3));
		setArmorBonus(1);
		setMaxDexBonus(-10);
		setArmorCheckPenalty(-1);
		setArcaneSpellFailure(0.05D);
		setSpeed(-10);
		setWeight(5);
	}
}
