package weapons.simple;

import res.Dice;
import res.Money.Silver;
import weapons.Weapon;

public class Dart extends Weapon {
	public Dart() { 
		super("Dart");
		super.setCost(new Silver(5));
		super.setDamage(new Dice(1, 4));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(20);
		super.setWeight(1);
		super.setType("Piercing");
	}
}
