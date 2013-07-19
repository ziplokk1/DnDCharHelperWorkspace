package weapons.simple;

import res.Dice;
import res.Money.Copper;
import weapons.Weapon;

public class Quarterstaff extends Weapon {
	public Quarterstaff() { 
		super("Quarterstaff");
		super.setCost(new Copper(0));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(4);
		super.setType("Bludgeoning");
	}
}
