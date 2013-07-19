package armor;

import res.Money.Gold;

public class BandedMail extends Armor {
	public BandedMail() {
		super("Banded Mail");
		setCost(new Gold(250));
		setArmorBonus(6);
		setMaxDexBonus(1);
		setArmorCheckPenalty(-6);
		setArcaneSpellFailure(0.35D);
		setSpeed(20);
		setWeight(35);
		setCanRunAtQuadSpeed(false);
	}
}
