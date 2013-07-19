package weapons.simple;

import res.Dice;
import res.Money.Copper;
import weapons.Weapon;

public class Club extends Weapon {
	public Club() { 
		super("Club");
		super.setCost(new Copper(0));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(10);
		super.setWeight(3);
		super.setType("Bludgeoning");
	}
}
