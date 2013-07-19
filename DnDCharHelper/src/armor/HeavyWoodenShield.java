package armor;

import res.Money.Gold;

public class HeavyWoodenShield extends Armor {
	public HeavyWoodenShield() {
		super("Shield, Heavy Wooden");
		setCost(new Gold(7));
		setArmorBonus(2);
		setMaxDexBonus(-10);
		setArmorCheckPenalty(-2);
		setArcaneSpellFailure(0.15D);
		setSpeed(-10);
		setWeight(10);
	}
}
