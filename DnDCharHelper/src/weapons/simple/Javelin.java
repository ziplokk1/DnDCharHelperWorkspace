package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Javelin extends Weapon {
	public Javelin() { 
		super("Javelin");
		super.setCost(new Gold(1));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(30);
		super.setWeight(2);
		super.setType("Piercing");
	}
}
