package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Longspear extends Weapon {
	public Longspear() { 
		super("Longspear");
		super.setCost(new Gold(5));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(9);
		super.setType("Piercing");
	}
}
