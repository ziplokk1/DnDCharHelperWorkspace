package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Rapier extends Weapon {
	public Rapier() { 
		super("Rapier");
		super.setCost(new Gold(20));
		super.setDamage(new Dice(1, 6));
		super.setCritical(18);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(2);
		super.setType("Piercing");
	}
}
