package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Shuriken extends Weapon {
	public Shuriken() { 
		super("Shuriken");
		super.setCost(new Gold(1));
		super.setDamage(new Dice(1, 2));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(10);
		super.setWeight(1);
		super.setType("Piercing");
	}
}
