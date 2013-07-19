package armor;

import res.Money.Gold;

public class SplintMail extends Armor {
	public SplintMail() {
		super("Splint Mail");
		setCost(new Gold(200));
		setArmorBonus(6);
		setMaxDexBonus(0);
		setArmorCheckPenalty(-7);
		setArcaneSpellFailure(0.4D);
		setSpeed(20);
		setWeight(45);
		setCanRunAtQuadSpeed(false);
	}
}
