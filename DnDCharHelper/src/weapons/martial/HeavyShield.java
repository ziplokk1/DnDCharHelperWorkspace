package weapons.martial;

import res.Dice;
import res.Money.Copper;
import weapons.Weapon;

public class HeavyShield extends Weapon {
	public HeavyShield() { 
		super("Shield, Heavy");
		super.setCost(new Copper(-1));
		super.setDamage(new Dice(1, 4));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(0);
		super.setType("Bludgeoning");
	}
}
