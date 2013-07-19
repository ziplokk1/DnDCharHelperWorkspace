package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class LightMace extends Weapon {
	public LightMace() { 
		super("Mace, Light");
		super.setCost(new Gold(5));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(4);
		super.setType("Bludgeoning");
	}
}
