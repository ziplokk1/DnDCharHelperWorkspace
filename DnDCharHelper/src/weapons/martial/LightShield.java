package weapons.martial;

import res.Dice;
import res.Money.Copper;
import weapons.Weapon;

public class LightShield extends Weapon {
	public LightShield() { 
		super("Shield, Light");
		super.setCost(new Copper(-1));
		super.setDamage(new Dice(1, 3));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(0);
		super.setType("Bludgeoning");
	}
}
