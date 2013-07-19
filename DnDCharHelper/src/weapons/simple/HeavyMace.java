package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class HeavyMace extends Weapon {
	public HeavyMace() { 
		super("Mace, Heavy");
		super.setCost(new Gold(12));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(8);
		super.setType("Bludgeoning");
	}
}
