package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class CompositeLongbow extends Weapon {
	public CompositeLongbow() { 
		super("Longbow, Composite");
		super.setCost(new Gold(100));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(110);
		super.setWeight(3);
		super.setType("Piercing");
	}
}
