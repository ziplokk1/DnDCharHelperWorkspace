package armor;

import res.Money.Gold;

public class FullPlate extends Armor {
	public FullPlate() {
		super("Full Plate");
		setCost(new Gold(1500));
		setArmorBonus(8);
		setMaxDexBonus(1);
		setArmorCheckPenalty(-6);
		setArcaneSpellFailure(0.35D);
		setSpeed(20);
		setWeight(50);
		setCanRunAtQuadSpeed(false);
	}
}
