package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Flail extends Weapon {
	public Flail() { 
		super("Flail");
		super.setCost(new Gold(8));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(5);
		super.setType("Bludgeoning");
	}
}
