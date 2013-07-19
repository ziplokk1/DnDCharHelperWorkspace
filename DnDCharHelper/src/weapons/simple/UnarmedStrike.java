package weapons.simple;

import res.Dice;
import res.Money.Copper;
import weapons.Weapon;

public class UnarmedStrike extends Weapon {
	public UnarmedStrike() { 
		super("Unarmed Strike");
		super.setCost(new Copper(0));
		super.setDamage(new Dice(1, 3));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(0);
		super.setType("Bludgeoning");
	}
}
