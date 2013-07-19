package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class SpikedGauntlet extends Weapon {
	public SpikedGauntlet() { 
		super("Gauntlet, Spiked");
		super.setCost(new Gold(5));
		super.setDamage(new Dice(1, 4));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(1);
		super.setType("Piercing");
	}
}
