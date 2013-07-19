package armor;

import res.Money.Gold;

public class LightSteelShield extends Armor {
	public LightSteelShield() {
		super("Shield, Light Steel");
		setCost(new Gold(9));
		setArmorBonus(1);
		setMaxDexBonus(-10);
		setArmorCheckPenalty(-1);
		setArcaneSpellFailure(0.05D);
		setSpeed(-10);
		setWeight(6);
	}
}
