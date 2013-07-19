package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Siangham extends Weapon {
	public Siangham() { 
		super("Siangham");
		super.setCost(new Gold(3));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(1);
		super.setType("Piercing");
	}
}
