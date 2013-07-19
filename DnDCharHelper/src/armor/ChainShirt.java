package armor;

import res.Money.Gold;

public class ChainShirt extends Armor {
	public ChainShirt() { 
		super("Chain Shirt");
		setCost(new Gold(100));
		setArmorBonus(4);
		setMaxDexBonus(4);
		setArmorCheckPenalty(-2);
		setArcaneSpellFailure(0.2D);
		setSpeed(30);
		setWeight(25);
	}
}
