package armor;

import res.Money.Gold;

public class Breastplate extends Armor {
	public Breastplate() { 
		super("Breast Plate");
		setCost(new Gold(200));
		setArmorBonus(5);
		setMaxDexBonus(3);
		setArmorCheckPenalty(-4);
		setArcaneSpellFailure(0.25D);
		setSpeed(20);
		setWeight(30);
		setCanRunAtQuadSpeed(false);
	}
}
