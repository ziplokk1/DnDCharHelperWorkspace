package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class DireFlail extends Weapon {
	public DireFlail() { 
		super("Flail, Dire");
		super.setCost(new Gold(90));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(10);
		super.setType("Bludgeoning");
	}
}
