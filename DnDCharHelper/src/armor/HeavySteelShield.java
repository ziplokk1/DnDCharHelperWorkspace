package armor;

import res.Money.Gold;

public class HeavySteelShield extends Armor {
	public HeavySteelShield() {
		super("Shield, Heavy Steel");
		setCost(new Gold(20));
		setArmorBonus(2);
		setMaxDexBonus(-10);
		setArmorCheckPenalty(-2);
		setArcaneSpellFailure(0.15D);
		setSpeed(-10);
		setWeight(15);
	}
}
