package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Gauntlet extends Weapon {
	public Gauntlet() { 
		super("Gauntlet");
		super.setCost(new Gold(2));
		super.setDamage(new Dice(1, 3));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(1);
		super.setType("Bludgeoning");
	}
}
