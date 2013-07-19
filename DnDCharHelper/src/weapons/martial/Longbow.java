package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Longbow extends Weapon {
	public Longbow() { 
		super("Longbow");
		super.setCost(new Gold(75));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(100);
		super.setWeight(3);
		super.setType("Piercing");
	}
}
