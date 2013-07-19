package weapons.simple;

import res.Dice;
import res.Money.Copper;
import weapons.Weapon;

public class Sling extends Weapon {
	public Sling() {
		super("Sling");
		super.setCost(new Copper(0));
		super.setDamage(new Dice(1, 4));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(50);
		super.setWeight(0);
		super.setType("Bludgeoning");
	}
}
