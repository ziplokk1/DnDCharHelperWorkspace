package armor;

import res.Money.Gold;

public class TowerShield extends Armor {
	public TowerShield() {
		super("Shield, Tower");
		setCost(new Gold(30));
		setArmorBonus(4);
		setMaxDexBonus(2);
		setArmorCheckPenalty(-10);
		setArcaneSpellFailure(0.50D);
		setSpeed(-10);
		setWeight(45);
		setHandNotFreeToCastSpells(true);
	}
}
