package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Shortbow extends Weapon {
	public Shortbow() { 
		super("Shortbow");
		super.setCost(new Gold(30));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(60);
		super.setWeight(2);
		super.setType("Piercing");
	}
}
