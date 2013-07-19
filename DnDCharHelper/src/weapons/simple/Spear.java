package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Spear extends Weapon {
	public Spear() { 
		super("Spear");
		super.setCost(new Gold(2));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(20);
		super.setWeight(6);
		super.setType("Piercing");
	}
}
