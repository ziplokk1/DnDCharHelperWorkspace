package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class CompositeShortbow extends Weapon {
	public CompositeShortbow() { 
		super("Shortbow, Composite");
		super.setCost(new Gold(75));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(70);
		super.setWeight(2);
		super.setType("Piercing");
	}
}
