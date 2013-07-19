package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Trident extends Weapon {
	public Trident() { 
		super("Trident");
		super.setCost(new Gold(15));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(10);
		super.setWeight(4);
		super.setType("Piercing");
	}
}
