package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class LightCrossbow extends Weapon {
	public LightCrossbow() { 
		super("Crossbow, Light");
		super.setCost(new Gold(35));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(80);
		super.setWeight(4);
		super.setType("Piercing");
	}
}
