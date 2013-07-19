package armor;

import res.Money.Gold;

public class HalfPlate extends Armor {
	public HalfPlate() {
		super("Half-Plate");
		setCost(new Gold(600));
		setArmorBonus(7);
		setMaxDexBonus(0);
		setArmorCheckPenalty(-7);
		setArcaneSpellFailure(0.4D);
		setSpeed(20);
		setWeight(50);
		setCanRunAtQuadSpeed(false);
	}
}
