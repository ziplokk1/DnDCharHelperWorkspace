package armor;

import res.Money.Gold;

public class Buckler extends Armor {
	public Buckler() {
		super("Buckler");
		setCost(new Gold(15));
		setArmorBonus(1);
		setMaxDexBonus(-10);
		setArmorCheckPenalty(-1);
		setArcaneSpellFailure(0.05D);
		setSpeed(-10);
		setWeight(5);
	}
}
