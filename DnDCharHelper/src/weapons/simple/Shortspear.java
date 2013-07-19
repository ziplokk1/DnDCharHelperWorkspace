package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Shortspear extends Weapon {
	public Shortspear() { 
		super("Shortspear");
		super.setCost(new Gold(1));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(20);
		super.setWeight(3);
		super.setType("piercing");
	}
}
